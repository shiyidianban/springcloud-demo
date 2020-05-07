package com.springcloud.demo.client.filter;

import com.springcloud.demo.common.enums.RespEnum;
import com.springcloud.demo.common.exception.ServiceException;
import com.springcloud.demo.common.util.ConstantsUtil;
import com.springcloud.demo.common.util.ObjectUtils;
import org.apache.catalina.connector.RequestFacade;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestFacade requestFacade = (RequestFacade) servletRequest;
        setLoginUserInfo(requestFacade);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 设置登录用户信息
     *
     * @param servletRequest
     */
    private void setLoginUserInfo(HttpServletRequest servletRequest) {
        String token = servletRequest.getHeader(ConstantsUtil.TOKEN);
        if (ObjectUtils.isNull(token)) {
            throw new ServiceException(RespEnum.NO_LOGIN);
        }

        AuthUserInfo userInfo = new AuthUserInfo(token);
        UserInfoLocal.setUser(userInfo);
    }
}
