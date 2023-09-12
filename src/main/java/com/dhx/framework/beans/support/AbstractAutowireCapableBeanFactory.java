package com.dhx.framework.beans.support;


import com.dhx.framework.beans.factory.config.BeanDefinition;

/**
 * @author adorabled4
 * @className AbstractAutowireCapableBeanFactory 抽象有自动装配bean能力的bean工厂
 * Capable : 有能力的；有本领的，能干的；可以……的，容许……的
 * @date : 2023/09/11/ 17:23
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName, beanDefinition);
    }

    Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Class className = beanDefinition.getBeanClass();
        Object bean;
        try {
            // 通过反射 获取类的实例
            bean = className.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        addSingleton(beanName, bean);
        return bean;
    }


}
