package com.example.weiyi.dao;

import com.example.weiyi.entity.Order;
import com.example.weiyi.entity.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 87248 on 2020-06-03 17:55
 */
public interface OrderDao extends JpaRepository<Order,Long> {

    List<Order> findByUser(User user);

}
