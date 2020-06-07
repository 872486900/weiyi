package com.example.weiyi.controller;

import com.example.weiyi.entity.Hospital;
import com.example.weiyi.service.AddressService;
import com.example.weiyi.service.DoctorService;
import com.example.weiyi.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Created by 87248 on 2020-06-04 11:41
 */
@Controller
public class HospitalControllere {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private DoctorService doctorService;


    @GetMapping("/hospitals")
    public String hospitals(Model model){
        model.addAttribute("provinces",addressService.findProvince());
        model.addAttribute("cities",addressService.findCityAll());
        model.addAttribute("hospitals",hospitalService.findAll());
        return "hospitals";
    }
    @GetMapping("/hospital/{hid}")
    public String hospital(Model model,
                           @PageableDefault(size = 4) Pageable pageable,
                           @PathVariable Long hid){
        model.addAttribute("doctors",doctorService.findByHid(hid,pageable));
        model.addAttribute("hospital",hospitalService.findByHid(hid));
        model.addAttribute("hid",hid);
        return "hospital";
    }


}
