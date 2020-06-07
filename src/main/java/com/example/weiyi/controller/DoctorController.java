package com.example.weiyi.controller;

import com.example.weiyi.entity.Doctor;
import com.example.weiyi.entity.Type;
import com.example.weiyi.service.DoctorService;
import com.example.weiyi.service.TypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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

    @GetMapping("zaixian")
    public String zaixian()
    {
        return "zaixian";
    }
}
