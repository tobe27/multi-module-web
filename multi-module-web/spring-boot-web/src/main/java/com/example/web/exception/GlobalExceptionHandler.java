package com.example.web.exception;

import com.example.service.exception.ServiceException;
import com.example.web.entity.ResultBean;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * WEB层统一异常处理-全局拦截异常后返回标准JSON格式
 * code = 400
 * message = e.getMessage()
 * @author Created by L.C.Y on 2018-11-20
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截校验异常并返回ResultBean
     * @param e MethodArgumentNotValidException异常
     * @return ResultBean
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultBean responseBindingException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder();
        FieldError fieldError = bindingResult.getFieldError();
        sb.append(Objects.requireNonNull(fieldError).getDefaultMessage());
        return new ResultBean().fail(sb.toString());
    }

    /**
     * 拦截ServiceException后返回ResultBean
     * @param e ServiceException异常
     * @return ResultBean
     */
    @ExceptionHandler(value = ServiceException.class)
    public ResultBean responseUserException(Exception e) {
        ServiceException serviceException;
        if (e instanceof ServiceException) {
            serviceException = (ServiceException) e;
        } else {
            serviceException = new ServiceException("未知异常");
        }
        return new ResultBean().fail(serviceException.getMessage());
    }

}
