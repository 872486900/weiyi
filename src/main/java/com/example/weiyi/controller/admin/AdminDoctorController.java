package com.example.weiyi.controller.admin;

import com.example.weiyi.entity.Doctor;
import com.example.weiyi.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 87248 on 2020-06-09 14:59
 */
@Controller
@RequestMapping("/admin")
public class AdminDoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping("/doctor_list")
    public String doctor(Model model,
                         @PageableDefault(size =5) Pageable pageable)
    {
        Page<Doctor> page = doctorService.findAll(pageable);
        model.addAttribute("page",page);
        model.addAttribute("count",doctorService.finAll());
        return "admin/doctor_list";
    }
}
