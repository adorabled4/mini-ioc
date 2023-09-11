package com.dhx.framework.adapter;

import com.dhx.framework.adapter.impl.NbLoggerImpl;
import com.dhx.framework.adapter.logger.LogFactory;

/**
 * @author adorabled4
 * @className Main
 * @date : 2023/09/10/ 20:17
 **/
public class Main {

    public static void main(String[] args) {
        LogFactory logger = new LogAdapter(new NbLoggerImpl());
        logger.debug("test","print logs");
    }
}
