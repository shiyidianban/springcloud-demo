package com.springcloud.demo.common.util;

/**
 * 常量字段
 *
 * @author FLY
 * @date 2020-05-07 9:34
 */
public class ConstantsUtil {

    /**
     * 设置token
     */
    public static final String TOKEN = "token";

    public static final String CREATE_BY = "createBy";

    public static final String CREATE_TIME = "createTime";

    public static final String UPDATE_BY = "updateBy";

    public static final String UPDATE_TIME = "updateTime";

    public static final String DEL_FLAG = "delFlag";

    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 12 * 60 * 60;

    public static final int REFRESH_TOKEN_VALIDITY_SECONDS = 30 * 24 * 60 * 60;
}
