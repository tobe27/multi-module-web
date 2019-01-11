package com.example.service.exception;

/**
 * 自定义异常
 * 运行时异常可以被事务回滚
 * @author Created by L.C.Y on 2018-11-20
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 2479864900505511996L;

    private String message;

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
