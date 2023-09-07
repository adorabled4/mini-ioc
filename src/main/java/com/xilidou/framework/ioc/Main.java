package com.xilidou.framework.ioc;

import com.xilidou.framework.ioc.core.JsonApplicationContext;
import com.xilidou.framework.ioc.model.Robot;
import com.xilidou.framework.ioc.model.circle.A;

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
        A a = (A)applicationContext.getBean("a");
        a.showB();
        a.getB().showA();
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
