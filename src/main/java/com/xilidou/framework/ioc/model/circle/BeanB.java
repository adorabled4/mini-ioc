package com.xilidou.framework.ioc.model.circle;

import lombok.Data;
import lombok.ToString;

/**
 * @author adorabled4
 * @className B
 * @date : 2023/09/07/ 14:57
 **/
//@Data
public class BeanB {

    BeanA beanA;

    String code;
    public void showA(){
        System.out.println(beanA + "code : " + code);
    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
