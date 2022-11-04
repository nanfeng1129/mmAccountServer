package com.ryan.mmaccountserver.unifiedreturn;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

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
        String str = "";
        if (e.getMessage() != null) {
            str = e.getMessage();
        } else {
            str = "";
        }
        return RespResult.fail(ResultCode.findCodeByMsg(str), e.getMessage());
    }
}
