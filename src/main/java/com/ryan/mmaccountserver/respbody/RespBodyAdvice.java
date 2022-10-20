package com.ryan.mmaccountserver.respbody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(basePackages = "com.ryan.mmaccountserver")
public class RespBodyAdvice implements ResponseBodyAdvice<Object> {
      /**
       * 是否支持advice功能
       * true=支持，false=不支持
       */
      @Autowired
      ObjectMapper objectMapper;
      @Override
      public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
      }
      /**
       *
       * 处理response的具体业务方法
       */
      @Override
      public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

            if (o instanceof String) {
                  try {
                        return objectMapper.writeValueAsString(RespResult.suc(o));
                  } catch (JsonProcessingException e) {
                        e.printStackTrace();
                  }
            }
            if(o instanceof RespResult){
                  return o;
            }
            return RespResult.suc(o);
      }
}
