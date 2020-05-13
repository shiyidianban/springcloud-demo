package com.springcloud.demo.common.filter;

import com.springcloud.demo.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一处理返回数据
 *
 * @author FLY
 * @date 2020-05-13 10:14
 */
@ControllerAdvice(annotations = {RestController.class})
@Slf4j
public class GlobalResultHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        final String returnTypeName = methodParameter.getParameterType().getName();
        return !"com.springcloud.demo.common.util.Result".equals(returnTypeName) &&
                !"org.springframework.http.ResponseEntity".equals(returnTypeName);
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        final String returnTypeName = methodParameter.getParameterType().getName();
        if ("void".equals(returnTypeName)) {
            return Result.success();
        }

        if (!mediaType.includes(MediaType.APPLICATION_JSON)) {
            return o;
        }

        if ("com.springcloud.demo.common.util.Result".equals(returnTypeName)) {
            return o;
        }

        return Result.success(o);
    }
}
