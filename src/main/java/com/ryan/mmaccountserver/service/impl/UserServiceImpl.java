package com.ryan.mmaccountserver.service.impl;

import com.ryan.mmaccountserver.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author Ryan
 * @date 2022-10-13
 */

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public Boolean login(String username, String password){
        return "lijw".equals(username) && "123456".equals(password);
    }
}
