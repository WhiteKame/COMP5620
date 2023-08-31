package com.project.virtualExhibition.service.exceptions;

/**密码校验失败的异常*/
public class PasswordIsWrongException extends ServiceException{
    public PasswordIsWrongException() {
        super();
    }

    public PasswordIsWrongException(String message) {
        super(message);
    }

    public PasswordIsWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordIsWrongException(Throwable cause) {
        super(cause);
    }

    protected PasswordIsWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
