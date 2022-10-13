package com.ryan.mmaccountserver.controller;


import com.ryan.mmaccountserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    IUserService userService;


    /**
     * @descript 登录方法
     * @param username 用户名
     * @param password 密码
     * @return 检验是否通过
     */
    @RequestMapping("login")
    public Boolean login(String username, String password){
        return userService.login(username, password);
    }
}
