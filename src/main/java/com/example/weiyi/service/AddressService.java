package com.example.weiyi.service;

import com.example.weiyi.entity.City;
import com.example.weiyi.entity.Province;
import com.example.weiyi.entity.Town;

import java.util.List;

/**
 * Created by 87248 on 2020-06-04 15:13
 */
public interface AddressService {
    List<Province> findProvince();
    List<City> findCityAll();
    List<City> findCity(String provinceCode);
    List<Town> findTown(String cityCode);
}
