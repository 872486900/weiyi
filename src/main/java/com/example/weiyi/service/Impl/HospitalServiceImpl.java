package com.example.weiyi.service.Impl;

import com.example.weiyi.dao.HospitalDao;
import com.example.weiyi.entity.Hospital;
import com.example.weiyi.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 87248 on 2020-06-04 11:45
 */
@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalDao hospitalDao;


    @Override
    public List<Hospital> findCode(String cityCode) {
        return hospitalDao.findByCityCode(cityCode);
    }

    @Override
    public List<Hospital> findAll() {
        return hospitalDao.findAll();
    }

    @Override
    public Hospital findByHid(Long Hid) {
        return hospitalDao.findByHid(Hid);
    }
}
