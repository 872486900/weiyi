package com.example.weiyi.controller.admin;

import com.example.weiyi.entity.Hospital;
import com.example.weiyi.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/hospital_add")
    public String add(){
        return "admin/hospital_add";

    }
    @ResponseBody
    @PostMapping("/hospital_add")
    public String sava(Hospital hospital){
        String hphoto ="/images/"+hospital.getHphoto();
        hospital.setHphoto(hphoto);
        Hospital hospital1 = hospitalService.savaHospital(hospital);
        System.out.println(hospital1);
        return "医院添加成功";
    }
}
