package com.example.weiyi.service;

import com.example.weiyi.entity.Hospital;

import java.util.List;

/**
 * Created by 87248 on 2020-06-04 11:44
 */
public interface HospitalService {

    List<Hospital> findCode(String cityCode);
    List<Hospital> findAll();
    Hospital findByHid(Long Hid);
}
