package com.example.weiyi.controller.admin;

import com.example.weiyi.entity.Admin;
import com.example.weiyi.entity.Doctor;
import com.example.weiyi.entity.Hospital;
import com.example.weiyi.entity.User;
import com.example.weiyi.service.AdminService;
import com.example.weiyi.service.DoctorService;
import com.example.weiyi.service.HospitalService;
import com.example.weiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by 87248 on 2020-06-07 22:14
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private HospitalService hospitalService;

    @GetMapping()
    public String index() {
        return "admin/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String Atel,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        Admin admin = adminService.login(Atel, password);
        if (admin!=null){
            session.setAttribute("admin",admin);
            System.out.println("管理员存在");
            return "admin/index";
        }else {
            System.out.println("管理员不存在");
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("admin");
        System.out.println("退出");
        return "admin/login";
    }

    @GetMapping("/welcome")
    public String welcom(Model model){
        model.addAttribute("user",userService.findAll());
        model.addAttribute("doctor",doctorService.finAll());
        model.addAttribute("admin",adminService.findAll());
        return "admin/welcome";
    }

    @GetMapping("/admin_list")
    public String admin(Model model){
        List<Admin> admins = adminService.findAll();
        model.addAttribute("admins",admins);
        return "admin/admin_list";
    }

    @GetMapping("/admin_add")
    public String addAdmin(){
        return "admin/admin_add";
    }
    @PostMapping("/admin_add")
    public String addAdmin(Admin admin){
        Admin admin1 = adminService.savaAdmin(admin);
        System.out.println(admin);
        return "admin/login";
    }




}
