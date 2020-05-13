package com.springcloud.demo.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.springcloud.demo.common.enums.RespEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 返回结果
 *
 * @author FLY
 * @date 2020-04-30 17:04
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {
    /**
     * 返回业务码
     */
    private long code;
    /**
     * 结果集
     */
    private T data;
    /**
     * 描述
     */
    private String msg;

    /**
     * 是否成功
     */
    private Boolean success;

    public Result() {
        // to do nothing
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 封装返回信息
     *
     * @param data 结果集
     * @param resp 响应结果（状态码及响应信息）
     * @param <T>
     * @return
     */
    public static <T> Result<T> restResult(T data, RespEnum resp, Boolean success) {
        return restResult(data, resp.getCode(), resp.getMsg(), success);
    }

    /**
     * 封装返回信息（无返回结果集）
     *
     * @param resp 响应结果
     * @param <T>
     * @return
     */
    public static <T> Result<T> restResult(RespEnum resp, Boolean success) {
        return restResult(null, resp.getCode(), resp.getMsg(), success);
    }

    /**
     * 封装返回信息（全信息）
     *
     * @param data 结果集
     * @param code 响应码
     * @param msg  响应信息
     * @param <T>
     * @return
     */
    private static <T> Result<T> restResult(T data, long code, String msg, Boolean success) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        apiResult.setSuccess(success);
        return apiResult;
    }

    /**
     * 操作成功
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        return restResult(RespEnum.SUCCESS, true);
    }

    /**
     * 操作成功并返回结果集
     *
     * @param data 结果集
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return restResult(data, RespEnum.SUCCESS, true);
    }

    /**
     * 操作失败并指定失败信息
     *
     * @param msg 响应信息
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(String msg) {
        return restResult(null, RespEnum.FAILED.getCode(), msg, false);
    }

    public static <T> Result<T> failed(long code, String msg) {
        return restResult(null, code, msg, false);
    }

    /**
     * 操作失败并返回报错信息
     *
     * @param e   报错信息对象
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(Throwable e) {
        return restResult(null, RespEnum.FAILED.getCode(), e.getMessage(), false);
    }

    /**
     * 封转错误枚举类
     *
     * @param respEnum 枚举类
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(RespEnum respEnum) {
        return restResult(null, respEnum, false);
    }
}