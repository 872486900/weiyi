package com.example.weiyi.controller;

import com.example.weiyi.entity.Doctor;
import com.example.weiyi.entity.Order;
import com.example.weiyi.entity.User;
import com.example.weiyi.service.DoctorService;
import com.example.weiyi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by 87248 on 2020-06-03 18:07
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/order")
    public String order(Model model,
                        HttpSession session,
                        @Valid Order order
                        ){
        //查找doctor
        order.setUser((User) session.getAttribute("user"));
        order.setDoctor(doctorService.findByDid((Long) session.getAttribute("did")));
        orderService.orderSave(order);


        return "redirect:/";
    }

    @GetMapping("order")
    public String order(Model model,
                        HttpSession session)
    {
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderService.findByUser(user);
        model.addAttribute("orders",orders);
        return "order";
    }


}
