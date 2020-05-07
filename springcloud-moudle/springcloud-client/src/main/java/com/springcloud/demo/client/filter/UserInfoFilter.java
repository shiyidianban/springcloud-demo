package com.springcloud.demo.client.filter;

import com.springcloud.demo.common.enums.RespEnum;
import com.springcloud.demo.common.util.ConstantsUtil;
import com.springcloud.demo.common.util.ObjectUtils;
import com.springcloud.demo.common.util.Result;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 用户信息拦截器
 *
 * @author FLY
 * @date 2020-05-07 10:04
 */
@Order(1)
@Component
@WebFilter
public class UserInfoFilter implements Filter {

    private String[] whiteUris = new String[]{
            "/v2/api-docs",
            "/swagger-resources",
            "/webjars",
            "/swagger-ui.html"
    };

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestFacade requestFacade = (RequestFacade) servletRequest;
        if (!inWhiteListUrl(requestFacade.getRequestURI()) && !setLoginUserInfo(requestFacade)) {
            servletResponse.setContentType("text/html;charset=UTF-8");
            servletResponse.getWriter().print(Result.restResult(RespEnum.NO_LOGIN).toString());
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 设置登录用户信息
     */
    private Boolean setLoginUserInfo(HttpServletRequest servletRequest) {
        String token = servletRequest.getHeader(ConstantsUtil.TOKEN);
        if (ObjectUtils.isNull(token)) {
            return false;
        }

        AuthUserInfo userInfo = new AuthUserInfo(token);
        UserInfoLocal.setUser(userInfo);
        return true;
    }

    /**
     * 白名单url放行
     */
    private boolean inWhiteListUrl(String requestUri) {

        for (String uri : whiteUris) {
            if (requestUri.startsWith(uri)) {
                return true;
            }
        }

        return false;
    }
}
