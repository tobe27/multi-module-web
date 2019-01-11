package com.example.common.enums;


/**
 * HTTP状态码
 * @author Created by L.C.Y on 2018-11-20
 */
public enum HttpCodeEnum {
    SUCCESS(200),
    SUCCESS_BUT_NO_CONTENT(204),
    REDIRECT(300),
    FAIL(400),
    UNAUTHORIZED(401),
    PAYMENT_REQUIRED(402),
    FORBIDDEN(403);

    private int code;
    HttpCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
