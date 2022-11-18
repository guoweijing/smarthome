package com.itheima.service;

import com.itheima.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

    public boolean login(String username, String password);

    public boolean register(String username, String password,String PhoneNumber);

    User show(String username);
}
