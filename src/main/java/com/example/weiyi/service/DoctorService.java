package com.example.weiyi.service;

import com.example.weiyi.entity.Doctor;
import com.example.weiyi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by 87248 on 2020-06-01 18:22
 */
public interface DoctorService {

    List<Doctor> finAll();
    Page<Doctor> findAll(Pageable pageable);
    //根据id查找
    Doctor findByDid(Long did);
    //在首页展示8个
    Page<Doctor> findEight(Pageable pageable);
    Page<Doctor> findByHid(Long Hid,Pageable pageable);
    void delDoctor(Long did);

    Doctor doctorRegister(Doctor doctor);
    Doctor doctorLogin(String Dtel,String pwd);
    Doctor updateDoctor(Long did,Doctor doctor);

}
