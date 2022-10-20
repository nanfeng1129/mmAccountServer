package com.ryan.mmaccountserver.controller;


import com.ryan.mmaccountserver.pojo.User;
import com.ryan.mmaccountserver.respbody.RespResult;
import com.ryan.mmaccountserver.respbody.ResultCode;
import com.ryan.mmaccountserver.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public Object login(@RequestBody User user){
        if(userService.login(user.getUsername(), user.getPassword())){
            return "登录成功";
        }else{
            return RespResult.fail(ResultCode.FAILURE.code(), "账号或密码错误");
//            return "账号或密码错误";
        }
    }
}
