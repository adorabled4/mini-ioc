package com.dhx.framework.ioc.core;

import com.dhx.framework.ioc.bean.BeanDefinition;
import com.dhx.framework.ioc.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;
import java.util.List;

/**
 * @author Zhengxin
 */
public class JsonApplicationContext extends BeanFactoryImpl{

    private String fileName;

    public JsonApplicationContext(String fileName) {
        this.fileName = fileName;
    }

    public void init(){
        loadFile();
    }

    private void loadFile(){

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        List<BeanDefinition> beanDefinitions = JsonUtils.readValue(is,new TypeReference<List<BeanDefinition>>(){});

        if(beanDefinitions != null && !beanDefinitions.isEmpty()) {

            for (BeanDefinition beanDefinition : beanDefinitions) {
                registerBean(beanDefinition.getName(), beanDefinition);
            }
        }

    }


}
