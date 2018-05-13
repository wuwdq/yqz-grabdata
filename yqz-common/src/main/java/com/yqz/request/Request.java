package com.yqz.request;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Request类，代表一个Http请求对象
 *
 * @author td
 * @version $Id: Request.java, v 0.1 2018年5月6日 下午10:32:11 td Exp $
 */
public class Request {
    /** url功能标识 **/
    private String                  id;
    /** 请求url地址 */
    private String                  url;
    /** 请求方法(默认get) */
    private Method                  method                    = Method.get;
    /** 超时设置 */
    private int                     connReqTimeoutMs          = 5000;
    private int                     socketTimeoutMs           = 8000;
    private int                     connTimeoutMs             = 5000;
    /** 最大跳转次数 */
    private int                     maxRedirects              = 3;
    /** 请求参数 */
    private Map<String, String>     params                    = new HashMap<String, String>();
    /** 供业务设置的header键值,ua不要在此处设置 */
    private List<Header>            headers                   = new ArrayList<Header>();
    /** ip绑定、cookie缓存有效时间(s) 默认360秒 6分钟 */
    private int                     cookieExpired             = 360;
    /** 自定义 SSLConnectionFactory，主要针对有些 https 证书不在信任范围内的问题 */
    private ConnectionSocketFactory sslConnectionFactory;
    /** 默认可重试上限 默认2 */
    private int                     retryLimit                = 2;
    /** 默认重试间隔 默认100ms */
    private int                     retryInterval             = 100;
    /** Request 字符集 */
    private CharsetEnum             charset                   = CharsetEnum.UTF8;
    /** 扩展的参数map，用于存放一些脚本需要的扩展信息*/
    private Map<String, Object>     extendParams              = new HashMap<String, Object>();
    /**字符串参数**/
    private HttpEntity              entity;
    /**业务重试次数，防止请求返回不完整导致解析报错,默认重试2次*/
    private int                     errorRetry                = 2;
    /** 设置get请求在302的情况下是否自动跳转 */
    private boolean                 autoRedirect              = true;
    /** 是否忽略网络超时,继续采集 */
    private boolean                 ignoreNetTimeoutException = false;
    /** 是否忽略所有异常,继续采集 */
    private boolean                 ignoreAllException        = false;
    /**
     * 是否跳过此次请求.
     */
    private boolean                 skipRequest               = false;

    private static final Logger     logger                    = LoggerFactory.getLogger(Request.class);

    public Request() {
    }

    public Request(String id, String url, Method method) {
        this.id = id;
        this.url = url;
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Request addParams(String key, String value) {
        this.params.put(key, value);
        return this;
    }

    public String getParameterByName(String name) {
        if (params.containsKey(name)) {
            return this.params.get(name);
        } else {
            return getValueFromUrl(this.url, name);
        }
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public Request addHeader(String key, String value) {
        this.headers.add(new BasicHeader(key, value));
        return this;
    }

    public String getHeaderByName(String name) {
        for (Header hd : headers) {
            String key = hd.getName();
            if (key.equalsIgnoreCase(name)) {
                return hd.getValue();
            }
        }
        return null;
    }
    
    public int getConnReqTimeoutMs() {
        return connReqTimeoutMs;
    }

    public void setConnReqTimeoutMs(int connReqTimeoutMs) {
        this.connReqTimeoutMs = connReqTimeoutMs;
    }

    public int getSocketTimeoutMs() {
        return socketTimeoutMs;
    }

    public void setSocketTimeoutMs(int socketTimeoutMs) {
        this.socketTimeoutMs = socketTimeoutMs;
    }

    public int getConnTimeoutMs() {
        return connTimeoutMs;
    }

    public void setConnTimeoutMs(int connTimeoutMs) {
        this.connTimeoutMs = connTimeoutMs;
    }

    public int getMaxRedirects() {
        return maxRedirects;
    }

    public void setMaxRedirects(int maxRedirects) {
        this.maxRedirects = maxRedirects;
    }

    public int getCookieExpired() {
        return cookieExpired;
    }

    public void setCookieExpired(int cookieExpired) {
        this.cookieExpired = cookieExpired;
    }

    public int getRetryLimit() {
        return retryLimit;
    }

    public void setRetryLimit(int retryLimit) {
        this.retryLimit = retryLimit;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public CharsetEnum getCharset() {
        return charset;
    }

    public void setCharset(CharsetEnum charset) {
        this.charset = charset;
    }

    public ConnectionSocketFactory getSslConnectionFactory() {
        return sslConnectionFactory;
    }

    public void setSslConnectionFactory(ConnectionSocketFactory sslConnectionFactory) {
        this.sslConnectionFactory = sslConnectionFactory;
    }

    public Map<String, Object> getExtendParams() {
        return extendParams;
    }

    public void setExtendParams(Map<String, Object> extendParams) {
        this.extendParams = extendParams;
    }

    public void addExtendParamsValue(String key, Object value) {
        this.extendParams.put(key, value);
    }

    public Object getExtendParamsValue(String key) {
        return this.extendParams.get(key);
    }

    public HttpEntity getEntity() {
        return entity;
    }

    public void setEntity(HttpEntity entity) {
        this.entity = entity;
    }

    public int getErrorRetry() {
        return errorRetry;
    }

    public void setErrorRetry(int errorRetry) {
        this.errorRetry = errorRetry;
    }

    public void setAutoRedirect(boolean autoRedirect) {
        this.autoRedirect = autoRedirect;
    }

    public boolean isAutoRedirect() {
        return autoRedirect;
    }

    public void setIgnoreNetTimeoutException(boolean ignoreNetTimeoutException) {
        this.ignoreNetTimeoutException = ignoreNetTimeoutException;
    }

    public boolean isIgnoreNetTimeoutException() {
        return ignoreNetTimeoutException;
    }

    public void setIgnoreAllException(boolean ignoreAllException) {
        this.ignoreAllException = ignoreAllException;
    }

    public boolean isIgnoreAllException() {
        return ignoreAllException;
    }

    public boolean isSkipRequest() {
        return skipRequest;
    }

    public void setSkipRequest(boolean skipRequest) {
        this.skipRequest = skipRequest;
    }

    /**
     * 获取url中的协议和host部分
     * 
     * @return
     */
    public String getUrlHost() {
        URL url = null;
        try {
            url = new URL(this.url);
            return url.getProtocol() + "://" + url.getHost();
        } catch (MalformedURLException e) {
            logger.error("request getUrlHost Exception", e);
        }
        return "";
    }

    /**
     * 从URLget参数里面取对应key的值
     * 
     * @param url
     * @param key
     * @return
     */
    public String getValueFromUrl(String url, String key) {
        List<NameValuePair> params = URLEncodedUtils.parse(url, Charset.forName("UTF-8"));
        for (NameValuePair nameValuePair : params) {
            if (StringUtils.equals(nameValuePair.getName(), key)) {
                return nameValuePair.getValue();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Request [id=" + id + ", url=" + url + ", method=" + method + ", connReqTimeoutMs=" + connReqTimeoutMs + ", socketTimeoutMs=" + socketTimeoutMs + ", connTimeoutMs=" + connTimeoutMs + ", maxRedirects=" + maxRedirects + ", params=" + params + ", headers=" + headers + ", cookieExpired=" + cookieExpired + ", sslConnectionFactory=" + sslConnectionFactory + ", retryLimit=" + retryLimit + ", retryInterval=" + retryInterval + ", charset=" + charset + ", extendParams=" + extendParams
               + ", entity=" + entity + ", errorRetry=" + errorRetry + ", autoRedirect=" + autoRedirect + ", ignoreNetTimeoutException=" + ignoreNetTimeoutException + ", ignoreAllException=" + ignoreAllException + ", skipRequest=" + skipRequest + "]";
    }
}
