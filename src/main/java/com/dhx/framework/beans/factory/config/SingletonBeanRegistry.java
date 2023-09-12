package com.dhx.framework.beans.factory.config;

/**
 * @author adorabled4
 * @className SingletonBeanRegistry 单例Bean注册表
 * @date : 2023/09/11/ 17:14
 **/
public interface SingletonBeanRegistry {

    Object getSingleton(String name);

}
