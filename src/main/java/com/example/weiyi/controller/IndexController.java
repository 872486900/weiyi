package com.example.weiyi.controller;

import com.example.weiyi.entity.Doctor;
import com.example.weiyi.entity.Hospital;
import com.example.weiyi.entity.Type;
import com.example.weiyi.entity.User;
import com.example.weiyi.service.DoctorService;
import com.example.weiyi.service.HospitalService;
import com.example.weiyi.service.TypeService;
import com.example.weiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.web.PageableDefault;

import javax.print.Doc;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 87248 on 2020-05-28 20:38
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/")
    public String index(Model model,
                        @PageableDefault(value = 8) Pageable pageable,
                        HttpSession session
                        ){
        List<Type> types = typeService.findAll();
        model.addAttribute("types",types);
        Page<Doctor> doctors = doctorService.findAll(pageable);
        model.addAttribute("doctors",doctors);
        Page<Doctor> page = doctorService.findEight(pageable);
        model.addAttribute("page",page);
        model.addAttribute("types",typeService.findAll());
        return "homepage";
    }

    @GetMapping("/guahao")
    public String guahao(){
        return "guahao";
    }

    @PostMapping("/guahao/{hid}")
    public String guahao(@PathVariable Long hid){
        return "guahao";

    }

    @GetMapping("baike")
    public String baike(){
        return "baike";
    }


//    @GetMapping("/wenzheng")
//        public String wenzheng(Model model,
//                @PageableDefault(value = 8) Pageable pageable
//                           ){
//            List<Type> types = typeService.findAll();
//            model.addAttribute("types",types);
//            List<Doctor> doctors = doctorService.finAll();
//            model.addAttribute("doctors",doctors);
//            //bug
////        Page<Doctor> page = doctorService.findAll(pageable);
////        model.addAttribute("page",page);
//            return "wenzheng";
//    }



}
