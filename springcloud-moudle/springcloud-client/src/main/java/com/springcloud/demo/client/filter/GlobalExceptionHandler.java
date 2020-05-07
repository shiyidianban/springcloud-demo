package com.springcloud.demo.client.filter;

import com.springcloud.demo.common.exception.ServiceException;
import com.springcloud.demo.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 全局异常处理
 *
 * @author FLY
 * @date 2020-05-07 10:10
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, Exception e) {
        if (e instanceof UndeclaredThrowableException) {
            e = (Exception) ((UndeclaredThrowableException) e).getUndeclaredThrowable();
        }

        if (e instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) e;
            return Result.failed(serviceException.getCode(), serviceException.getMessage());
        }

        log.error("", e);
        return Result.failed(e);
    }
}
