package com.dhx.framework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author adorabled4
 * @className UrlResource url资源
 * @date : 2023/09/11/ 16:35
 **/
public class UrlResource implements Resource {
    private final URL url;

    UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        try {
            return urlConnection.getInputStream();
        } catch (IOException ex) {
            throw ex;
        }
    }
}
