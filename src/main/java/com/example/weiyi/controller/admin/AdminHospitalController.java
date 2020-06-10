package com.example.weiyi.controller.admin;

import com.example.weiyi.entity.Hospital;
import com.example.weiyi.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 87248 on 2020-06-09 15:00
 */
@Controller
@RequestMapping("/admin")
public class AdminHospitalController {
    @Autowired
    private HospitalService hospitalService;
    @GetMapping("/hospital_list")
    public String hospital(Model model,
                           @PageableDefault(size =5) Pageable pageable)
    {
        List<Hospital> hospitals = hospitalService.findAll();
        model.addAttribute("hospitals",hospitals);
        return "admin/hospital_list";
    }
}
