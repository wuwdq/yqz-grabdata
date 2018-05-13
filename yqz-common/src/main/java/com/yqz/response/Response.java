package com.yqz.response;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;

import com.yqz.request.Request;

import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.utils.UrlUtils;

/**
 * 代表一个Http请求的返回对象
 *
 * @author td
 * @version $Id: Response.java, v 0.1 2018年5月6日 下午11:14:07 td Exp $
 */
public class Response {
    /** 状态码 */
    private int          statusCode;
    /** 请求对象 */
    private Request      request;
    /** 请求返回数据 */
    private byte[]       data;
    /** 字符集 */
    private String       chartset;
    /** 请求返回时带的response */
    private List<Header> headers;

    /**
     * String constructor
     * 
     * @param statusCode
     * @param request
     * @param data
     */
    public Response(int statusCode, Request request, String data) {
        this.statusCode = statusCode;
        this.request = request;
        this.data = data.getBytes();
    }

    /**
     * Byte Array Constructor
     * 
     * @param statusCode
     * @param request
     * @param data
     * @param chartset
     */
    public Response(int statusCode, Request request, byte[] data, String chartset) {
        this.statusCode = statusCode;
        this.request = request;
        this.data = data;
        this.chartset = chartset;
    }

    /**
     * 取得 String 类型数据
     * 
     * @return
     */
    public String getContent() {
        if (StringUtils.isNotBlank(chartset)) {
            try {
                return new String(data, chartset);
            } catch (UnsupportedEncodingException e) {
                return new String(data);
            }
        } else {
            return new String(data);
        }
    }

    /**
     * 返回从页面源代码生成的 HTML 对象
     * 
     * @return
     */
    public Html getHtml() {
        // TODO json 字符串判断等
        return new Html(UrlUtils.fixAllRelativeHrefs(getContent(), request.getUrl()));// 替换链接相对路径为绝对路径
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public String getChartset() {
        return chartset;
    }

    public void setChartset(String chartset) {
        this.chartset = chartset;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getHeader(String key) {
        for (Header header : headers) {
            if (StringUtils.equals(header.getName(), key)) {
                return header.getValue();
            }
        }
        return null;
    }

    /**
     * 获取header里的key一样的键值，例如Set-Cookie
     * 
     * @param key
     * @return
     */
    public List<String> getHeaderList(String key) {
        List<String> hdrs = new ArrayList<String>();
        for (Header header : headers) {
            if (StringUtils.equalsIgnoreCase(header.getName(), key)) {
                String value = header.getValue();
                hdrs.add(value);
            }
        }

        return hdrs;
    }
}
