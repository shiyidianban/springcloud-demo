package com.springcloud.demo.common.filter;

/**
 * 当前用户登录信息
 *
 * @author FLY
 * @date 2020-05-07 10:16
 */
public class UserInfoLocal {

    private static ThreadLocal<AuthUserInfo> local = new ThreadLocal<>();

    /**
     * 设置当前登录用户信息
     *
     * @param userInfo
     */
    public static void setUser(AuthUserInfo userInfo) {
        local.set(userInfo);
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
    public static AuthUserInfo getUser() {
        return local.get();
    }
}
