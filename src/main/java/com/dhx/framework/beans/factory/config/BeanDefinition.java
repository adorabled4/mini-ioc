package com.dhx.framework.beans.factory.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @author adorabled4
 * @className BeanDefinition bean定义
 * @date : 2023/09/11/ 17:13
 **/
@Getter
@Setter
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class clazz) {
        this.beanClass = clazz;
    }

}
