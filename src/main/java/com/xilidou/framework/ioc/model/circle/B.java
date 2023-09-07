package com.xilidou.framework.ioc.model.circle;

import lombok.Data;

/**
 * @author adorabled4
 * @className B
 * @date : 2023/09/07/ 14:57
 **/
@Data
public class B {

    A a;
    public void showA(){
        System.out.println(a);
    }
}
