package com.example.weiyi.service;

import com.example.weiyi.entity.User;

import java.util.List;

/**
 * Created by 87248 on 2020-05-30 16:52
 */
public interface UserService {
    List<User> findAll();
    User userRegister(User user);
    User userLogin(String tel,String pwd);
    void delete(Long usid);
}
