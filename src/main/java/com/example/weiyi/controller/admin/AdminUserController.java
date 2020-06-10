package com.example.weiyi.controller.admin;

import com.example.weiyi.entity.User;
import com.example.weiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 87248 on 2020-06-09 14:58
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user_list")
    public String user(Model model)
    {
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "admin/user_list";
    }
    @ResponseBody
    @RequestMapping("/user_del/{usid}")
    public String deleteUser(@PathVariable Long usid){
        userService.delete(usid);
        return null;
    }
}
