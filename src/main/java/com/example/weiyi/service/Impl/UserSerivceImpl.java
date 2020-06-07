package com.example.weiyi.service.Impl;

import com.example.weiyi.dao.UserDao;
import com.example.weiyi.entity.User;
import com.example.weiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 87248 on 2020-05-30 16:52
 */
@Service
public class UserSerivceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User userRegister(User user) {
        return userDao.save(user);
    }

    @Override
    public User userLogin(String tel, String pwd) {
        return userDao.findByTelAndPwd(tel,pwd);
    }
}
