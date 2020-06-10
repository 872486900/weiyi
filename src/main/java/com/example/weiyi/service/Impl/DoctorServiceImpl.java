package com.example.weiyi.service.Impl;

import com.example.weiyi.dao.DoctorDao;
import com.example.weiyi.entity.Doctor;
import com.example.weiyi.entity.Hospital;
import com.example.weiyi.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by 87248 on 2020-06-01 18:22
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;

    @Override
    public List<Doctor> finAll() {
        return doctorDao.findAll();
    }

    @Override
    public Page<Doctor> findAll(Pageable pageable) {
        return doctorDao.findAll(pageable);
    }

    @Override
    public Doctor findByDid(Long did) {

        return doctorDao.getOne(did);
    }


    //在首页展示八个
    @Override
    public Page<Doctor> findEight(Pageable pageable) {
        Page<Doctor> doctors = doctorDao.findAll(pageable);
        return doctors;

    }

    @Override
    public Page<Doctor> findByHid(Long Hid,Pageable pageable) {
        Hospital hospital = new Hospital();
        hospital.setHid(Hid);
        return doctorDao.findByHospital(hospital,pageable);
    }

    @Override
    public void delDoctor(Long did) {
        doctorDao.deleteById(did);
    }

    @Override
    public Doctor doctorRegister(Doctor doctor) {
        return doctorDao.save(doctor);
    }

    @Override
    public Doctor doctorLogin(String Dtel, String pwd) {
        return doctorDao.findByDtelAndPwd(Dtel,pwd);
    }
}
