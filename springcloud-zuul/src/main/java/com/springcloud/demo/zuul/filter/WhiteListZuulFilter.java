package com.springcloud.demo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.springcloud.demo.common.enums.RespEnum;
import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.zuul.config.WhiteListProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;

/**
 * 拦截白名单
 *
 * @author FLY
 * @date 2020-05-13 14:10
 */
@Component
public class WhiteListZuulFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WhiteListZuulFilter.class);

    @Autowired
    private WhiteListProperties whiteListProperties;

    @Autowired
    private RouteLocator routeLocator;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Route route = routeLocator.getMatchingRoute(request.getRequestURI());
        if (route == null) {
            return null;
        }
        String ipAddr = getIpAddr(request);
        LOGGER.info("请求IP地址为：[{}]", ipAddr);
        // 配置本地IP白名单，生产环境可放入数据库或者redis中
        if (!whiteListProperties.inWhiteList(route.getLocation(), ipAddr)) {
            LOGGER.info("IP地址校验不通过!!!");
            context.setResponseStatusCode(401);
            context.setSendZuulResponse(false);
            context.getResponse().setContentType("application/json; charset=utf-8");
            context.setResponseBody(Result.failed(RespEnum.NO_IP_ADDRESS.getCode(), String.format(RespEnum.NO_IP_ADDRESS.getMsg(), ipAddr)).toString());
            return null;
        }

        LOGGER.info("IP校验通过。");
        return null;
    }

    /**
     * 获取Ip地址
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (isUnknownAddress(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnknownAddress(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnknownAddress(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (isUnknownAddress(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (isUnknownAddress(ip)) {
            ip = request.getRemoteAddr();
            String localIp = "127.0.0.1";
            String localIpv6 = "0:0:0:0:0:0:0:1";
            if (ip.equals(localIp) || ip.equals(localIpv6)) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        return ip;
    }

    private boolean isUnknownAddress(String ip) {
        return ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip);
    }
}
