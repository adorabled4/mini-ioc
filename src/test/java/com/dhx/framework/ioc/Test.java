package com.dhx.framework.ioc;

import com.dhx.framework.ioc.core.JsonApplicationContext;
import com.dhx.framework.ioc.entity.Robot;

public class Test {

    public static void main(String[] args) throws Exception {

        JsonApplicationContext applicationContext = new JsonApplicationContext("application.json");
        applicationContext.init();
        Robot aiRobot = (Robot) applicationContext.getBean("robot");

        aiRobot.show();

    }

}
