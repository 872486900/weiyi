package com.example.weiyi.service;

import com.example.weiyi.entity.Admin;

import java.util.List;

/**
 * Created by 87248 on 2020-06-08 12:36
 */
public interface AdminService {
    Admin login(String Atel,String password);
    List<Admin> findAll();
    Admin savaAdmin(Admin admin);
}
