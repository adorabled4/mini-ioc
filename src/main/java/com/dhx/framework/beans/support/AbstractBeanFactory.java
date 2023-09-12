package com.dhx.framework.beans.support;


import com.dhx.framework.beans.BeanFactory;
import com.dhx.framework.beans.factory.config.BeanDefinition;

/**
 * @author adorabled4
 * @className AbstractBeanFactory
 * @date : 2023/09/11/ 17:16
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {
        // 首先查看bean是否是单例bean , 如果没有就去查找bean的定义 , 然后去创建bean
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);


    protected abstract BeanDefinition getBeanDefinition(String name);

}
