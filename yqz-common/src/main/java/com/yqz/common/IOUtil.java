package com.yqz.common;

import java.io.Closeable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理一些与IO相关的动作
 *
 * @author td
 * @version $Id: IOUtil.java, v 0.1 2018年5月7日 上午12:34:49 td Exp $
 */
public final class IOUtil {

    private static final Logger logger = LoggerFactory.getLogger(IOUtil.class);

    public static void closeQuietly(Closeable closeable) {
        try {
            if (null != closeable) {
                closeable.close();
            }
        } catch (Exception e) {
            logger.error("Something is wrong here", e);
        }
    }
}
