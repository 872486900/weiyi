package com.example.weiyi.controller.admin;

import com.example.weiyi.entity.Admin;
import com.example.weiyi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 87248 on 2020-06-11 14:31
 */
@Controller
@RequestMapping("/admin")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order_list")
    public String order(Model model, HttpSession session){
        model.addAttribute("orders",orderService.findAll());
        return "admin/order_list";
    }

    @GetMapping("/order_add")
    public String add(){
        return "admin/order_add";
    }

}
