/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.yqz.http;

import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.yqz.request.Request;

import us.codecraft.webmagic.downloader.HttpClientDownloader;

/**
 * 构造抽象请求
 *
 * @author td
 * @version $Id: AbstractHttpClient.java, v 0.1 2018年5月6日 下午11:25:50 td Exp $
 */
public abstract class AbstractHttpClient extends HttpClientDownloader {

    protected RequestBuilder initBuilder(Request request) {
        RequestBuilder builder;
        switch (request.getMethod()) {
            case get:
                builder = RequestBuilder.get();
                break;
            case post:
                builder = RequestBuilder.post();

                if (request.getEntity() != null) {
                    builder.setEntity(request.getEntity());
                }
                // 设置post参数
                if (request.getParams() != null && request.getParams().size() > 0) {
                    NameValuePair[] params = new BasicNameValuePair[request.getParams().size()];
                    int i = 0;
                    for (Map.Entry<String, String> entry : request.getParams().entrySet()) {
                        params[i++] = new BasicNameValuePair(entry.getKey(), entry.getValue());
                    }
                    builder.addParameters(params);
                }
                break;
            default:
                throw new IllegalArgumentException(String.format("请求方法[%s]非法!", request.getMethod()));
        }
        return builder;
    }
}
