package com.example.weiyi.service.Impl;

import com.example.weiyi.dao.OrderDao;
import com.example.weiyi.entity.Doctor;
import com.example.weiyi.entity.Order;
import com.example.weiyi.entity.User;
import com.example.weiyi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 87248 on 2020-06-03 17:57
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Order orderSave(Order order) {

        return orderDao.save(order);
    }

    @Override
    public List<Order> findByUser(User user) {
        return orderDao.findByUser(user);
    }

    @Override
    public List<Order> findbyDoctor(Doctor doctor) {
        return orderDao.findByDoctor(doctor);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }
}
