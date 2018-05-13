package com.yqz.factory;

import com.yqz.request.Request;

/**
 *  拼装请求header头
 */
public class HeaderFactory {
    
    public static void getSubjectHeader(Request request){
        request.addHeader("Accept", "*/*");
        request.addHeader("X-Requested-With", "XMLHttpRequest");
        getCommonHeader(request);
    }
    
    public static void getSubjecDetailHeader(Request request){
        request.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        request.addHeader("Cache-Control", "max-age=0");
        request.addHeader("Upgrade-Insecure-Requests", "1");
        getCommonHeader(request);
    }
    
    public static void getSubjecCommentHeader(Request request){
        request.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        request.addHeader("Cache-Control", "max-age=0");
        request.addHeader("Upgrade-Insecure-Requests", "1");
        getCommonHeader(request);
    }
    
    public static void getCommonHeader(Request request){
        request.addHeader("Accept-Encoding", "gzip, deflate, br");
        request.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
        request.addHeader("Connection", "keep-alive");
        request.addHeader("Host", "movie.douban.com");
        //        request.addHeader("Referer", "https://movie.douban.com/explore");
        request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
    }
}
