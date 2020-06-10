package com.example.weiyi.service.Impl;

import com.example.weiyi.dao.AdminDao;
import com.example.weiyi.entity.Admin;
import com.example.weiyi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 87248 on 2020-06-08 12:36
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin login(String Atel, String password) {
        Admin admin = adminDao.findByAtelAndPassword(Atel, password);
        Long aid = admin.getAid();
        int update = adminDao.update(aid, new Date());
        System.out.println(update);
        return admin;
    }

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public Admin savaAdmin(Admin admin) {
        return adminDao.save(admin);
    }
}
