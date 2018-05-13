package com.yqz.http;

import com.yqz.request.Request;
import com.yqz.response.Response;

/**
 * 露给上层调用的Http客户端接口
 *
 * @author td
 * @version $Id: HttpClient.java, v 0.1 2018年5月6日 下午10:29:47 td Exp $
 */
public interface HttpClientInterface {

    /**
     * 下载接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    Response download(Request request) throws Exception;
}
