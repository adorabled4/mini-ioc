package com.dhx.framework.ioc;

import com.dhx.framework.ioc.core.JsonApplicationContext;
import com.dhx.framework.ioc.model.Robot;
import com.dhx.framework.ioc.model.circle.BeanA;

/**
 * @author adorabled4
 * @className Main
 * @date : 2023/09/07/ 14:36
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        circleDepeTest();
    }

    static void circleDepeTest() throws Exception {
        JsonApplicationContext applicationContext = new JsonApplicationContext("application.json");
        applicationContext.init();
        BeanA beanA = (BeanA)applicationContext.getBean("beanA");
        beanA.showB();
        System.out.println(beanA);
    }

    /**
     * 基础功能测试
     * @throws Exception
     */
    static void baseTest() throws Exception {
        JsonApplicationContext applicationContext = new JsonApplicationContext("application.json");
        applicationContext.init();
        Robot robot = (Robot) applicationContext.getBean("robot");
        System.out.println(robot.toString());
    }

}
