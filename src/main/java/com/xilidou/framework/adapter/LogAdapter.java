package com.xilidou.framework.adapter;

import com.xilidou.framework.adapter.logger.LogFactory;
import com.xilidou.framework.adapter.logger.NbLogger;

import java.util.Objects;

/**
 * @author adorabled4
 * @className LogAdapter 通过适配器模式 ,使得新定义的logger可以适配原本的LogFactory
 * @date : 2023/09/10/ 20:15
 **/
public class LogAdapter implements LogFactory {
    private NbLogger nbLogger;

    public LogAdapter(NbLogger nbLogger) {
        this.nbLogger = nbLogger;
    }

    @Override
    public void debug(String tag, String message) {
        Objects.requireNonNull(nbLogger);
        nbLogger.udebug(1, message);
    }
}
