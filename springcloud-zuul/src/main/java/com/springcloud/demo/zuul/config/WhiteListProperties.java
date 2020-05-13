package com.springcloud.demo.zuul.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 白名单配置
 *
 * @author FLY
 * @date 2020-05-13 13:58
 */
@RefreshScope
@ConfigurationProperties(prefix = "zuul")
public class WhiteListProperties {

    private Map<String, List<String>> whiteList = new HashMap<>();

    public Map<String, List<String>> getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(Map<String, List<String>> whiteList) {
        this.whiteList = whiteList;
    }

    /**
     * @param address
     * @return
     */
    public boolean inWhiteList(String serviceId, String address) {
        Assert.notNull(serviceId, "服务名称不能为空");
        List<String> addrList = whiteList.get(serviceId);
        return addrList != null && addrList.contains(address);
    }
}
