package com.springcloud.demo.common.filter;

import lombok.Data;

/**
 * 用户信息
 *
 * @author FLY
 * @date 2020-05-07 10:16
 */
@Data
public class AuthUserInfo {

    private String token;

    public AuthUserInfo(){}

    public AuthUserInfo(String token){
        this.token = token;
    }
}
