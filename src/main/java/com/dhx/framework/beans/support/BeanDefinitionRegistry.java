package com.dhx.framework.beans.support;


import com.dhx.framework.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 *
 * @author adorabled4
 * @className BeanDefinitionRegistry
 * @date : 2023/09/11/ 17:15
 **/
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
