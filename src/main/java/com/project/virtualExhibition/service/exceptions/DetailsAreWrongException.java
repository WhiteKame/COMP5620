package com.project.virtualExhibition.service.exceptions;


public class DetailsAreWrongException extends ServiceException{
    public DetailsAreWrongException() {
        super();
    }

    public DetailsAreWrongException(String message) {
        super(message);
    }

    public DetailsAreWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public DetailsAreWrongException(Throwable cause) {
        super(cause);
    }

    protected DetailsAreWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
