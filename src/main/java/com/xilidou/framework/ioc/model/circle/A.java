package com.xilidou.framework.ioc.model.circle;

import lombok.Data;

/**
 * @author adorabled4
 * @className A
 * @date : 2023/09/07/ 14:57
 **/
@Data
public class A {

    B b;

    public void showB(){
        System.out.println(b);
    }
}
