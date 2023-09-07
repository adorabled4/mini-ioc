package com.xilidou.framework.ioc.model.circle;

import lombok.Data;
import lombok.ToString;

/**
 * @author adorabled4
 * @className A
 * @date : 2023/09/07/ 14:57
 **/
//@Data
public class BeanA {

    String code;
    BeanB beanB;

    public void showB() {
        System.out.println(beanB + "code : " + code);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }
}
