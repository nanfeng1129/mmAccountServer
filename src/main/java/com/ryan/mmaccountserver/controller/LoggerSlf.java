package com.ryan.mmaccountserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class LoggerSlf {

    @RequestMapping("/loggerSlf")
    public String logger(){
        log.trace("日志级别：trace");
        log.debug("日志级别：debug");
        log.info("日志级别：info");
        log.warn("日志级别：warn");
        log.error("日志级别：error");

        return "logger";
    }
}
