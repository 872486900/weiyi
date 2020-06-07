package com.example.weiyi.dao;

import com.example.weiyi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 87248 on 2020-05-30 16:51
 */
public interface UserDao extends JpaRepository<User,Long> {
    //登录
    User findByTelAndPwd(String tel,String pwd);
}
