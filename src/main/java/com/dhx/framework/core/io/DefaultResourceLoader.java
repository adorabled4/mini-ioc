package com.dhx.framework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author adorabled4
 * @className DefaultResourceLoader
 * @date : 2023/09/11/ 16:38
 **/
public class DefaultResourceLoader implements ResourceLoader {

    public static final String CLASSPATH_PREFIX = "classpath:";

    @Override
    public Resource getResource(String location) {
        // 获取顺序 : classpath => url => fileSystem
        if (location.startsWith(CLASSPATH_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 当成文件系统来处理
                return new FileSystemResource(location);
            }

        }
    }
}
