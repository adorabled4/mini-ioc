package com.dhx.framework.ioc.core;

import com.dhx.framework.ioc.bean.BeanDefinition;
import com.dhx.framework.ioc.bean.ConstructorArg;
import com.dhx.framework.ioc.bean.PropertyArg;
import com.dhx.framework.ioc.utils.BeanUtils;
import com.dhx.framework.ioc.utils.ClassUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BeanFactoryImpl implements BeanFactory {

    private static final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String, BeanDefinition> beanDefineMap = new ConcurrentHashMap<>();

    private static final Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());

    private final Map<String, Object> earlySingletonObjects = new HashMap<String, Object>(16);

    @Override
    public Object getBean(String name) throws Exception {
        //查找对象是否已经实例化过
        Object bean = beanMap.get(name);
        if (bean != null) {
            return bean;
        }
        Object earlyBean = earlySingletonObjects.get(name);
        if (earlyBean != null) {
            System.out.println("发生循环依赖, 提前返回尚未加载完的Bean : " + name);
            return earlyBean;
        }
        //如果没有实例化，那就需要调用createBean来创建对象
        BeanDefinition beanDefinition = beanDefineMap.get(name);
        bean = createBean(beanDefinition);

        if (bean != null) {
            earlySingletonObjects.put(name,bean);
            //对象创建成功以后，注入对象需要的参数
            populatebean(bean,beanDefinition);
            //再吧对象存入Map中方便下次使用。
            beanMap.put(name, bean);
            // 完全实例化之后(填充完参数之后) 删除预先的单例bean
            earlySingletonObjects.remove(name);
        }

        //结束返回
        return bean;
    }

    protected void registerBean(String name, BeanDefinition bd) {
        beanDefineMap.put(name, bd);
        beanNameSet.add(name);
    }

    /**
     *  创建Bean (尚未完全实例化)
     * @param beanDefinition
     * @return {@link Object}
     * @throws Exception
     */
    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        String beanName = beanDefinition.getClassName();
        Class clz = ClassUtils.loadClass(beanName);
        if (clz == null) {
            throw new Exception("can not find bean by beanName");
        }
        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        if (constructorArgs != null && !constructorArgs.isEmpty()) {
            List<Object> objects = new ArrayList<>();
            for (ConstructorArg constructorArg : constructorArgs) {
                if (constructorArg.getValue() != null) {
                    objects.add(constructorArg.getValue());
                } else {
                    objects.add(getBean(constructorArg.getRef()));
                }
            }
            Class[] constructorArgTypes = objects.stream().map(it -> it.getClass()).collect(Collectors.toList()).toArray(new Class[]{});
            Constructor constructor = clz.getConstructor(constructorArgTypes);
            return BeanUtils.instanceByCglib(clz, constructor, objects.toArray());
        } else {
            return BeanUtils.instanceByCglib(clz, null, null);
        }
    }

    /**
     * 注入Bean的属性
     * @param bean
     * @param bd
     * @throws Exception
     */
    private void populatebean(Object bean, BeanDefinition bd) throws Exception {
        List<PropertyArg> propertyArgs = bd.getPropertyArgs();
        if (propertyArgs != null && !propertyArgs.isEmpty()) {
            //遍历在json中配置的属性
            for (PropertyArg arg : propertyArgs) {
                String propertyName = arg.getName();
                String value = arg.getValue();
                String ref = arg.getRef();
                Object injectValue = null;
                if (value != null) {
                    //直接赋值
                    injectValue = value;
                } else if (ref != null && !"".equals(ref)) {
                    //获取bean
                    injectValue = getBean(ref);
                }
                Method method = getPropertySetter(bd, propertyName, injectValue);
                method.invoke(bean, injectValue);
            }
        }
    }

    /**
     * 获取具体某个属性的setter方法
     * 此处做法比较简单粗暴
     * 实际上Spring在读取配置文件时就已经将各属性，方法，getter/setter都读取好了。
     * 在这就只需要调用BeanWrapper的方法来为属性赋值就可以了。
     */
    private Method getPropertySetter(BeanDefinition bd, String propertyName, Object injectValue) throws Exception {
        Class beanClass = Class.forName(bd.getClassName());
        Class injectClazz = injectValue.getClass();
        Class supClass = injectValue.getClass().getSuperclass();
        if (supClass != null && supClass != Object.class) {
            injectClazz = supClass;
        }
        propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        Method setter = beanClass.getMethod("set" + propertyName, injectClazz);
        return setter;
    }
}
