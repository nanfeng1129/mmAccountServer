package com.ryan.mmaccountserver.controller;


import com.ryan.mmaccountserver.pojo.User;
import com.ryan.mmaccountserver.unifiedreturn.RespResult;
import com.ryan.mmaccountserver.unifiedreturn.ResultCode;
import com.ryan.mmaccountserver.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService userService;


    /**
     * @descript 登录方法
     * @param user
     * @return 检验是否通过
     */
    @PostMapping("login")
    public String login(@RequestBody User user, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        System.out.println("---session----" + session);

        if(userService.login(user.getUsername(), user.getPassword())){
            session.setAttribute("username", user.getUsername());
            session.setMaxInactiveInterval(2 * 60 * 60);
            System.out.println(session.getAttribute("username"));
            System.out.println(session.getId());
            return session.getId();
        }else{
            throw new Exception("账号或密码错误");
//            return RespResult.fail(ResultCode.FAILURE.code(), "账号或密码错误");
        }
    }
    @PostMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();

        return "退出登录成功";
    }

    @PostMapping("checkLogin")
    public Object checkLogin(){

        return "账号已登录";
    }
}
