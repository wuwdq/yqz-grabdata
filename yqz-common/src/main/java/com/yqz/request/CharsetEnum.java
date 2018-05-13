package com.yqz.request;

/**
 * 编码格式枚举
 *
 * @author td
 * @version $Id: CharsetEnum.java, v 0.1 2018年5月7日 上午12:20:58 td Exp $
 */
public enum CharsetEnum {
    UTF8("utf-8"), GBK("gbk");
    
    CharsetEnum(String charset) {
        this.charset = charset;
    }

    private String charset;

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

}
