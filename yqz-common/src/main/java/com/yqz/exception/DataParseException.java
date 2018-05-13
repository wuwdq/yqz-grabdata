package com.yqz.exception;

public class DataParseException extends BaseException{
    /** */
    private static final long serialVersionUID = -8982958843735099505L;

    public DataParseException(String message) {
        super(message);
    }
    
    public DataParseException(Throwable cause) {
        super(cause);
    }
    
    public DataParseException(String message, Throwable cause) {
        super(message, cause);
    }

}
