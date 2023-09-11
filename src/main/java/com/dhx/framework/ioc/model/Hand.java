package com.dhx.framework.ioc.model;

import lombok.Data;

/**
 * @author adorabled4
 * @className Hand
 * @date : 2023/09/07/ 14:44
 **/
@Data
public class Hand {
    public void waveHand(){
        System.out.println("挥一挥手");
    }
}
