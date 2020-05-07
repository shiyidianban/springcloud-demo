package com.springcloud.demo.common.exception;

import com.springcloud.demo.common.enums.RespEnum;

/**
 * 异常错误
 *
 * @author FLY
 * @date 2020-05-07 10:06
 */
public class ServiceException extends RuntimeException {

    private long code;
    private String message;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }

    public ServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(RespEnum respEnum) {
        this.code = respEnum.getCode();
        this.message = respEnum.getMsg();
    }

    public ServiceException(RespEnum respEnum, String message) {
        this.code = respEnum.getCode();
        this.message = respEnum.getMsg() + "-" + message;
    }

    public ServiceException(Exception e) {
        this.code = -1;
        this.message = e.getMessage();
    }

    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
