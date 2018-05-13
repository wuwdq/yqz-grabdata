package com.yqz.http.impl;

import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.RedirectException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yqz.common.IOUtil;
import com.yqz.http.AbstractHttpClient;
import com.yqz.http.HttpClientInterface;
import com.yqz.http.builder.MyHttpClientBuilder;
import com.yqz.http.exception.Http404Exception;
import com.yqz.request.Request;
import com.yqz.response.Response;

/**
 * http客户端实现类
 *
 * @author td
 * @version $Id: HttpClientImpl.java, v 0.1 2018年5月6日 下午11:43:51 td Exp $
 */
public class HttpClientImpl extends AbstractHttpClient implements HttpClientInterface {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpClientImpl.class);

    /** UA在request header中的key值 */
    private final static String UA_KEY = "User-Agent";

    public HttpClientImpl() {
        super();
    }

    @Override
    public Response download(Request request) throws Exception {
        return sendRequest(request);
    }

    /**
     * 发送请求
     *
     * @param request
     * @return
     * @throws Exception
     */
    private Response sendRequest(Request request) throws Exception {
        // 生成Http客户端
        CloseableHttpClient httpClient = generateClient(request);
        // 组装http uri请求
        HttpUriRequest req = generateUriRequest(request);
        CloseableHttpResponse httpResponse = null;
        Response response = null;

        int retryTimes = 0;
        try {
            do {
                try {
                    // 执行请求
                    httpResponse = httpClient.execute(req);
                    // 分析response
                    response = new Response(httpResponse.getStatusLine().getStatusCode(), request, "");
                    if (404 == response.getStatusCode()) {
                        throw new Http404Exception("404");
                    }
                    // 设置headers
                    response.setHeaders(Arrays.asList(httpResponse.getAllHeaders()));
                    // 取内容和编码
                    if (null != httpResponse.getEntity()) {
                        byte[] contentBytes = null;
                        InputStream in = null;
                        ByteArrayOutputStream out = null;
                        try {
                            out = new ByteArrayOutputStream();
                            HttpEntity httpEntity = httpResponse.getEntity();
                            in = httpEntity.getContent();
                            byte[] temp = new byte[1024];
                            int size = 0;
                            try {
                                while ((size = in.read(temp)) != -1) {
                                    out.write(temp, 0, size);
                                }
                            } catch (ConnectionClosedException e) {

                            } catch (SocketTimeoutException e) {

                            }
                            contentBytes = out.toByteArray();
                        } finally {
                            in.close();
                            out.close();
                        }
                        response.setData(contentBytes);
                    }
                    if (null != httpResponse.getEntity().getContentType()) {
                        response.setChartset(getHtmlCharset(httpResponse, response.getData()));
                    }
                    break;
                } catch (ClientProtocolException e) {
                    if (e.getCause() instanceof RedirectException) {
                        LOGGER.error("ClientProtocolException", retryTimes, e);
                        throw e;
                    } else {
                        LOGGER.error("failed", retryTimes, e);
                        retryTimes++;
                        if (retryTimes > request.getRetryLimit()) {
                            LOGGER.warn("尝试机会耗尽!不再重试", retryTimes, request.getRetryLimit());
                            throw e;
                        } else {
                            //重新组装request
                            req = generateUriRequest(request);
                            LOGGER.warn("尚有尝试机会!重试", retryTimes, request.getRetryLimit(), request.getRetryInterval());
                            // 等待一段时间重试
                            Thread.currentThread().sleep(request.getRetryInterval());
                        }
                    }
                } catch (Exception e) {
                    LOGGER.error("failed", "Exception", retryTimes, e);
                    retryTimes++;
                    if (retryTimes > request.getRetryLimit()) {
                        LOGGER.warn("尝试机会耗尽!不再重试", retryTimes, request.getRetryLimit());
                        throw e;
                    } else {
                        //重新组装request
                        req = generateUriRequest(request);
                        LOGGER.warn("尚有尝试机会!重试", retryTimes, request.getRetryLimit(), request.getRetryInterval());
                        // 等待一段时间重试
                        Thread.currentThread().sleep(request.getRetryInterval());
                    }
                } finally {
                    //需要先关闭流
                    if (null != httpResponse) {
                        EntityUtils.consumeQuietly(httpResponse.getEntity());
                    }
                    // 关闭http客户端和请求response
                    IOUtil.closeQuietly(httpResponse);
                }
            } while (retryTimes <= request.getRetryLimit());
        } finally {
            IOUtil.closeQuietly(httpClient);
        }
        return response;
    }

    /**
     * 生成一个CloseableHttpClient实例
     *
     * @param request 请求对象
     * @param proxy 代理
     * @return
     */
    private CloseableHttpClient generateClient(Request request) {
        HttpClientBuilder builder = new MyHttpClientBuilder();
        // 设置http/https支持
        ConnectionSocketFactory sslConnFactory = SSLConnectionSocketFactory.getSocketFactory();
        if (request.getSslConnectionFactory() != null) {
            sslConnFactory = request.getSslConnectionFactory();
        }

        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.INSTANCE).register("https", sslConnFactory).build();
        builder.setConnectionManager(new BasicHttpClientConnectionManager(registry));
        builder.setDefaultSocketConfig(SocketConfig.custom().setSoKeepAlive(true).setTcpNoDelay(true).build());

        return builder.build();
    }

    /**
     * 构造Http Uri 请求对象
     *
     * @param request 请求
     * @param proxy 代理
     * @return
     */
    private HttpUriRequest generateUriRequest(Request request) {
        RequestBuilder builder = initBuilder(request);
        // 设置charset
        builder.setCharset(Charset.forName(request.getCharset().getCharset()));
        // 设置url
        builder.setUri(request.getUrl());
        // 设置超时时间
        RequestConfig.Builder config = RequestConfig.custom().setConnectionRequestTimeout(request.getConnReqTimeoutMs()).setSocketTimeout(request.getSocketTimeoutMs()).setConnectTimeout(request.getConnTimeoutMs()).setMaxRedirects(request.getMaxRedirects()).setRedirectsEnabled(request.isAutoRedirect());
        builder.setConfig(config.build());
        // 设置headers
        boolean uaSet = false;
        if (!CollectionUtils.isEmpty(request.getHeaders())) {
            for (Header header : request.getHeaders()) {
                builder.addHeader(header);
                if (!uaSet && UA_KEY.equalsIgnoreCase(header.getName())) {
                    // 表示业务上自己设置了UA
                    uaSet = true;
                }
            }
        }
        return builder.build();
    }
}