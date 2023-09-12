package com.dhx.framework.beans;


import java.util.HashMap;

/**
 * @author adorabled4
 * @interface BeanFactory
 * @date : 2023/09/11/ 17:10
 **/
public interface BeanFactory {

    /**
     * 获取bean
     * @param name
     * @return {@link Object}
     */
    Object getBean(String name);
}
