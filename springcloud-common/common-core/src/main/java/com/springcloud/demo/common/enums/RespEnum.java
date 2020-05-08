package com.springcloud.demo.common.enums;

/**
 * 封装controller中的返回对象及状态枚举（模仿mybatis plus 提供的R对象及IErrorCode枚举)
 *
 * @author FLY
 * @date 2020-04-30 17:02
 */
public enum RespEnum {
    /**
     * 成功
     */
    SUCCESS(0, "操作成功"),
    /**
     * 失败
     */
    FAILED(1, "操作失败"),

    /**
     * 未登录
     */
    NO_LOGIN(10, "未登录"),
    /**
     * 无权限
     */
    NO_PERMISSION(12, "无权限操作");
    private final long code;
    private final String msg;

    RespEnum(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RespEnum fromCode(long code) {
        RespEnum[] ecs = values();
        for (RespEnum ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }

    /**
     * 状态码
     *
     * @return
     */
    public long getCode() {
        return code;
    }

    /**
     * 描述
     */
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return String.format(" RespEnum:{code=%s, msg=%s} ", code, msg);
    }
}
