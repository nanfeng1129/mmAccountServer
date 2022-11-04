package com.ryan.mmaccountserver.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryan.mmaccountserver.unifiedreturn.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interceptor implements HandlerInterceptor {

    /**
     * 访问控制器方法前执行
     */
    @Autowired
    ObjectMapper objectMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("-----preHandler-----" + request.getRequestURL());
        HttpSession session = request.getSession();

//        System.out.println(session.getAttribute("demo"));

//        System.out.println("----session-----" + session.getAttribute("demo"));
        if (session != null && session.getAttribute("username") != null) {
            System.out.println("成功放行");
            return true;
        } else {
            System.out.println("成功拦截");
//            PrintWriter printWriter = response.getWriter();
//            String str = objectMapper.writeValueAsString(RespResult.fail(ResultCode.UNAUTHORIZED.code(), ResultCode.UNAUTHORIZED.message()));
//            printWriter.write(str);
            throw new Exception(ResultCode.UNAUTHORIZED.message());
//            return false;
        }

    }

    /**
     * 访问控制器方法后执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("------postHandle------" + request.getRequestURL());
    }

    /**
     * postHandle 方法执行完成后执行，一般用于释放资源
     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        System.out.println("-------afterCompletion---------" + request.getRequestURL());
//    }


}
