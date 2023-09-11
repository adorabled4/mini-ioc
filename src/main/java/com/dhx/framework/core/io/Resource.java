package com.dhx.framework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author adorabled4
 * @interface Resource
 * @date : 2023/09/11/ 16:30
 **/
public interface Resource {

    InputStream getInputStream() throws IOException;
}
