package com.example.weiyi.controller;


import com.example.weiyi.entity.*;
import com.example.weiyi.service.AddressService;
import com.example.weiyi.service.HospitalService;
import com.example.weiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by 87248 on 2020-05-30 17:08
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/register")
    public String register(){
        return "register";
    }



    @GetMapping("/one")
    @ResponseBody
    public List<Province> selall(){
        return addressService.findProvince();
    }

    @RequestMapping("/two")
    @ResponseBody
    public List<City> selerji(String provinceCode){
        return addressService.findCity(provinceCode);
    }
    @GetMapping("/three")
    @ResponseBody
    public List<Town> sanji(String cityCode){
        return addressService.findTown(cityCode);
    }

    //多级联动
    @RequestMapping("/four")
    @ResponseBody
    public List<Hospital> siji(String cityCode,Model model,HttpSession session){
        session.setAttribute("code",cityCode);
        return hospitalService.findCode(cityCode);
    }


    @PostMapping("/register")
    public String register(User user,
                           RedirectAttributes attributes,
                           Model model,
                           HttpServletRequest request

    ){

        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String area = request.getParameter("area");
        String address = province + "/" + city + "/" + area;
        user.setAddress(address);
        userService.userRegister(user);
        System.out.println("注册成功，请登录");
        attributes.addFlashAttribute("message", "注册成功，请登录");
        model.addAttribute("message","注册成功，请登录");
        return "/login";
    }


    //登录
    @GetMapping("/login")
    public String userLogin(){
        return "login";
    }
    @PostMapping("/login")
    public String userLoign(@RequestParam String tel,
                            @RequestParam String pwd,
                            HttpSession session,
                            RedirectAttributes attributes,
                            Model model){
        User user = userService.userLogin(tel, pwd);
        System.out.println(user);
        if (user!=null){
            user.setPwd(null);
            session.setAttribute("user",user);
            System.out.println("登录成功");
            model.addAttribute("message","登录成功");
            return "redirect:/";
        } else {
            attributes.addFlashAttribute("message", "用户登录失败,请重新输入");
            System.out.println("用户登录失败");
            return "redirect:/login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        System.out.println("退出登录");
        return "redirect:/";

    }



}
