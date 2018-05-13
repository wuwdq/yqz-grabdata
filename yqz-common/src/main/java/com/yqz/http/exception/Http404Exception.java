package com.yqz.http.exception;

/**
 * 404异常
 *
 * @author td
 * @version $Id: Http404Exception.java, v 0.1 2018年5月7日 上午12:27:02 td Exp $
 */
public class Http404Exception extends RuntimeException {
    /** */
    private static final long serialVersionUID = 1L;
    private String            code;                 //异常对应的返回码
    private String            message;              //异常对应的描述信息

    public Http404Exception() {
        super();
    }

    public Http404Exception(String message) {
        super();
        this.message = message;
    }

    public Http404Exception(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
