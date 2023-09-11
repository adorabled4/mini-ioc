package com.dhx.framework.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author adorabled4
 * @className ClassPathResource 类路径资源
 * @date : 2023/09/11/ 16:31
 **/
public class ClassPathResource implements Resource {

    private final String path;

    ClassPathResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if(is==null){
            throw new FileNotFoundException(this.path+" can not opened becuase it does not exist");
        }
        return is;
    }
}
