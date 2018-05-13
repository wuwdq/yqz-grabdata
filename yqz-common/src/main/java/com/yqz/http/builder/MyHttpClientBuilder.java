package com.yqz.http.builder;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestTargetHost;

/**
 * 自定义的HttpClientBuilder
 *
 * @author td
 * @version $Id: MyHttpClientBuilder.java, v 0.1 2018年5月6日 下午11:46:26 td Exp $
 */
public class MyHttpClientBuilder extends HttpClientBuilder {

    @Override
    protected ClientExecChain createMainExec(HttpRequestExecutor requestExec, HttpClientConnectionManager connManager, ConnectionReuseStrategy reuseStrategy, ConnectionKeepAliveStrategy keepAliveStrategy, HttpProcessor proxyHttpProcessor, AuthenticationStrategy targetAuthStrategy, AuthenticationStrategy proxyAuthStrategy, UserTokenHandler userTokenHandler) {
        return super.createMainExec(requestExec, connManager, reuseStrategy, keepAliveStrategy, new ImmutableHttpProcessor(new HttpRequestInterceptor[] { new RequestTargetHost() }), targetAuthStrategy, proxyAuthStrategy, userTokenHandler);
    }

}
