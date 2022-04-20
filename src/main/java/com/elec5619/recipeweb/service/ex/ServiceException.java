package com.elec5619.recipeweb.service.ex;


// baseEntity of Service
// the exception happen in the running
public class ServiceException extends RuntimeException{

    // 如果像抛出空，则直接使用 空的构造；
    // throw new ServiceException()

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
