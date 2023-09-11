package com.dhx.framework.ioc.model;

import lombok.Data;

/**
 * @author adorabled4
 * @className Robot
 * @date : 2023/09/07/ 14:44
 **/
@Data
public class Robot {

    //需要注入 hand 和 mouth
    private Hand hand;
    private Mouth mouth;

    public void show(){
        hand.waveHand();
        mouth.speak();
    }
}
