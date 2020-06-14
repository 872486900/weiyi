package com.example.weiyi.service;

import com.example.weiyi.entity.Doctor;
import com.example.weiyi.entity.Order;
import com.example.weiyi.entity.User;
import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * Created by 87248 on 2020-06-03 17:56
 */
public interface OrderService {
    Order orderSave(Order order);

    List<Order> findByUser(User user);
    List<Order> findbyDoctor(Doctor doctor);
    List<Order> findAll();

}
