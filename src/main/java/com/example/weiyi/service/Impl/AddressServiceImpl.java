package com.example.weiyi.service.Impl;

import com.example.weiyi.dao.CityDao;
import com.example.weiyi.dao.ProvinceDao;
import com.example.weiyi.dao.TownDao;
import com.example.weiyi.entity.City;
import com.example.weiyi.entity.Province;
import com.example.weiyi.entity.Town;
import com.example.weiyi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 87248 on 2020-06-04 15:15
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private CityDao cityDao;
    @Autowired
    private TownDao townDao;


    @Override
    public List<Province> findProvince() {
        return provinceDao.findAll();
    }

    public List<City> findCityAll() {
        return cityDao.findAll();
    }


    @Override
    public List<City> findCity(String provinceCode) {
        return cityDao.findByProvinceCode(provinceCode);
    }

    @Override
    public List<Town> findTown(String cityCode) {
        return townDao.findByCityCode(cityCode);
    }
}
