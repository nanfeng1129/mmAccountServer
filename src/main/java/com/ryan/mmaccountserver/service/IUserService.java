package com.ryan.mmaccountserver.service;

public interface IUserService {
    /**
     * @description 登录
     * @param username 账号
     * @param password 密码
     * @return boolean
     */
    Boolean login(String username, String password);
}
