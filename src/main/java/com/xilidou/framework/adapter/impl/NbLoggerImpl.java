package com.xilidou.framework.adapter.impl;

import com.xilidou.framework.adapter.logger.NbLogger;

/**
 * @author adorabled4
 * @className NbLoggerImpl 新定义的logger实现
 * @date : 2023/09/10/ 20:15
 **/
public class NbLoggerImpl implements NbLogger {

    @Override
    public void udebug(int uuid, String message, Object... objects) {
        System.out.println(String.format("牛逼logger记录:%s",message));
    }
}
