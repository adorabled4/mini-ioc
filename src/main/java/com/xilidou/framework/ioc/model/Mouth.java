package com.xilidou.framework.ioc.model;

import lombok.Data;

/**
 * @author adorabled4
 * @className Mouth
 * @date : 2023/09/07/ 14:44
 **/
@Data
public class Mouth {
    public void speak(){
        System.out.println("say hello world");
    }
}