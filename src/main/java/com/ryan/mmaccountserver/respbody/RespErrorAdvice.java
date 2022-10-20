package com.ryan.mmaccountserver.respbody;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
@ResponseBody
public class RespErrorAdvice {

    @ExceptionHandler({NoHandlerFoundException.class})
    public RespResult<String> NotFound(HttpServletRequest req, Exception e) {
        log.debug("Error: 404 Not Found", e);
        return RespResult.fail(ResultCode.FAILURE.code(), "404 Not Found");
    }

    @ExceptionHandler({Exception.class})
    public RespResult<String> handleException(Exception e) {
        log.error("Error: " + e.getMessage());
        return RespResult.fail(ResultCode.FAILURE.code(), e.getMessage());
    }
}
