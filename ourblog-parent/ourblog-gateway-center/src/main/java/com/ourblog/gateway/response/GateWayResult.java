package com.ourblog.gateway.response;

import lombok.Data;

/**
 * @Author yudachi
 * @Description 网关鉴权返回对象
 * @Date 2021/1/22 14:17
 * @Version 1.0
 **/
@Data
public class GateWayResult<T> {
    private long code;
    private String message;
    private T data;

    protected GateWayResult() {
    }

    protected GateWayResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @param data 获取的数据
     */
    public static <T> GateWayResult<T> success(T data) {
        return new GateWayResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> GateWayResult<T> success(T data, String message) {
        return new GateWayResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> GateWayResult<T> failed(IErrorCode errorCode) {
        return new GateWayResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> GateWayResult<T> failed(IErrorCode errorCode, String message) {
        return new GateWayResult<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> GateWayResult<T> failed(String message) {
        return new GateWayResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> GateWayResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> GateWayResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> GateWayResult<T> validateFailed(String message) {
        return new GateWayResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> GateWayResult<T> unauthorized(T data) {
        return new GateWayResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> GateWayResult<T> forbidden(T data) {
        return new GateWayResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
}
