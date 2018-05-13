package com.yqz.service;

import com.yqz.exception.DataParseException;
import com.yqz.response.Response;
import com.yqz.result.ParseResult;

/**
 * 数据爬取接口
 *
 * @author td
 * @version $Id: GrabDataJobService.java, v 0.1 2018年5月7日 下午2:29:17 td Exp $
 */
public interface GrabDataService<T> {

    /**
     * 解析数据
     *
     * @param httpClient http客户端
     * @param urls 种子Url
     * @return
     */
    ParseResult<T> parse(Response response) throws DataParseException;
    
}
