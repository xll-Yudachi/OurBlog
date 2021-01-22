package com.ourblog.gateway.response;

/**
 * @Author yudachi
 * @Description 封装API的错误码
 * @Date 2021/1/22 14:20
 * @Version 1.0
 **/
public interface IErrorCode {
    long getCode();

    String getMessage();
}
