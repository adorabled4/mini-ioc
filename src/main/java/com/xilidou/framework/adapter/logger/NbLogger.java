package com.xilidou.framework.adapter.logger;

/**
 * @author adorabled4
 * @interface NbLogger 新定义的logger
 * @date : 2023/09/10/ 20:14
 **/
public interface NbLogger {

    void udebug(int uuid, String message, Object... objects);
}
