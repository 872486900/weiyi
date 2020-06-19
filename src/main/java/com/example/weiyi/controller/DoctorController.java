package com.example.weiyi.controller;

import com.example.weiyi.entity.Doctor;
import com.example.weiyi.entity.Hospital;
import com.example.weiyi.entity.Order;
import com.example.weiyi.entity.Type;
import com.example.weiyi.service.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by 87248 on 2020-06-02 15:10
 */
@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private OrderService orderService;

    @GetMapping("doctor/login")
    public String docotr(){
        return "doctor/login";
    }
    @PostMapping("doctor/login")
    public String docotr(@RequestParam String Dtel,
                         @RequestParam String pwd,
                         HttpSession session,
                         RedirectAttributes attributes,
                         Model model){
        Doctor doctor = doctorService.doctorLogin(Dtel, pwd);
        if (doctor!=null){
            doctor.setPwd(null);
            session.setAttribute("doctor",doctor);
            System.out.println("登录成功");
            model.addAttribute("message","登录成功");
            return "redirect:/doctor/index";
        } else {
            attributes.addFlashAttribute("message", "用户登录失败,请重新输入");
            System.out.println("用户登录失败");
            return "redirect:/doctor/login";
        }

    }

    @GetMapping("doctor/register")
    public String register(){
        return "doctor/register";
    }
    @PostMapping("doctor/register")
    public String register(Doctor doctor,
                           Model model,
                           HttpSession session,
                           HttpServletRequest request){
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String area = request.getParameter("area");
        String address = province + "/" + city + "/" + area;
        doctor.setDaddress(address);
        String dphoto = "/images/"+request.getParameter("dphoto");
        doctor.setDphoto(dphoto);
        doctorService.doctorRegister(doctor);
        System.out.println("注册成功，请登录");
        model.addAttribute("message","注册成功，请登录");
        return "doctor/login";
    }
    @GetMapping("doctor/logout")
    public String logout(HttpSession session){
        session.removeAttribute("doctor");
        return "redirect:/";
    }

    @RequestMapping("/doctor/{did}")
    public String doctor(Model model,
                          @PathVariable Long did,
                          HttpSession session,
                         @PageableDefault(size = 4) Pageable pageable
                          ){
        session.setAttribute("did",did);
        System.out.println(did);
        Doctor doctor = doctorService.findByDid(did);
        model.addAttribute("doctor",doctor);
        model.addAttribute("page",doctorService.findEight(pageable));
        return "doctor";
    }


    @GetMapping("/wenzheng")
    public String wenzheng(Model model,
                           @PageableDefault(value = 8) Pageable pageable
    ) {
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
        List<Doctor> doctors = doctorService.finAll();
        model.addAttribute("doctors", doctors);
        //bug
//        Page<Doctor> page = doctorService.findAll(pageable);
//        model.addAttribute("page",page);
        return "wenzheng";
    }
    @GetMapping("/yuyue/{did}")
    public String yuyue(@PathVariable Long did,
                        Model model
                        ){
//        System.out.println(doctorService.findByDid(did));
        model.addAttribute("doctor",doctorService.findByDid(did));
        return "yuyue";
    }

    @GetMapping("/doctors")
    public String doctors(Model model){
        model.addAttribute("doctors",doctorService.finAll());
        return "doctors";
    }

    @GetMapping("zaixian/{did}")
    public String zaixian(Model model,
                          @PathVariable Long did)
    {
        model.addAttribute("doctor",doctorService.findByDid(did));
        return "zaixian";
    }


    @GetMapping("doctor/index")
    public String index(){
        return "doctor/index";
    }

    @GetMapping("doctor/welcome")
    public String welcome(){
        return "doctor/welcome";
    }

    @GetMapping("doctor/about")
    public String about(Model model,HttpSession session){
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        Long did = doctor.getDid();
        System.out.println(did);
        Doctor doctor1 = doctorService.findByDid(did);
        model.addAttribute("doctor",doctor1);
        System.out.println(doctor1);
        model.addAttribute("hospitals",hospitalService.findAll());
        model.addAttribute("types",typeService.findAll());
        return "doctor/about";
    }

    @PostMapping("doctor/update/{did}")
    public String update(@Valid Long did,
                         @Valid Long hid,
                         @Valid Long tid,
                         Model model,
                         Doctor doctor
                         ){
        System.out.println(doctor);
        doctor.setHospital(hospitalService.findByHid(hid));
        doctor.setType(typeService.findOne(tid));
        Doctor doctor1 = doctorService.updateDoctor(did, doctor);
        return "redirect:/doctor/about";
    }

    @GetMapping("doctor/order_list")
    public String order(Model model,
                        HttpSession session){
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        List<Order> orders = orderService.findbyDoctor(doctor);
        model.addAttribute("orders",orders);
        return "doctor/order_list";
    }
}
