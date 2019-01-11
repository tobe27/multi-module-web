package com.example.web.entity;

import com.example.common.enums.HttpCodeEnum;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 用于WEB层标准输出格式
 * code
 * message
 * count
 * data
 * @author Created by L.C.Y on 2018-11-20
 */
public class ResultBean extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 7112950860836859973L;
    private static final String CODE = "code";
    private static final String MESSAGE = "message";
    private static final String COUNT = "count";
    private static final String DATA = "data";

    /**
     * 请求成功
     * @return
     */
    public ResultBean success() {
        this.put(CODE, HttpCodeEnum.SUCCESS.getCode());
        this.put(MESSAGE, HttpCodeEnum.SUCCESS);
        return this;
    }

    /**
     * 请求成功并返回数据
     * @param data 返回的数据
     * @return
     */
    public ResultBean success(Object data) {
        if (data == null) {
            this.put(CODE, HttpCodeEnum.SUCCESS_BUT_NO_CONTENT.getCode());
            this.put(MESSAGE, HttpCodeEnum.SUCCESS_BUT_NO_CONTENT);
            return this;
        }
        this.put(CODE, HttpCodeEnum.SUCCESS.getCode());
        this.put(MESSAGE, HttpCodeEnum.SUCCESS);
        this.put(DATA, data);
        return this;
    }

    /**
     * 请求成功并返回数据
     * @param count 数据列数
     * @param data 返回的数据
     * @return
     */
    public ResultBean success(long count, List data) {
        if (data == null || data.isEmpty()) {
            this.put(CODE, HttpCodeEnum.SUCCESS_BUT_NO_CONTENT.getCode());
            this.put(MESSAGE, HttpCodeEnum.SUCCESS_BUT_NO_CONTENT);
            return this;
        }
        this.put(CODE, HttpCodeEnum.SUCCESS.getCode());
        this.put(MESSAGE, HttpCodeEnum.SUCCESS);
        this.put(COUNT, count);
        this.put(DATA, data);
        return this;
    }


    /**
     * 请求失败，并返回失败信息
     * @param message 失败信息
     * @return
     */
    public ResultBean fail(String message) {
        this.put(CODE, HttpCodeEnum.FAIL.getCode());
        this.put(MESSAGE, message);
        return this;
    }

    /**
     * 追加自定义数据
     * @param key 数据标识
     * @param data 数据
     * @return
     */
    public ResultBean withMore(String key, Object data) {
        this.put(key, data);
        return this;
    }



}
