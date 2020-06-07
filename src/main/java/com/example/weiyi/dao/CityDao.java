package com.example.weiyi.dao;

import com.example.weiyi.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.*;
import java.util.List;

/**
 * Created by 87248 on 2020-06-04 15:11
 */
public interface CityDao extends JpaRepository<City,Integer> {
    @Query("select c from City c where c.ProvinceCode=:provinceCode")
    List<City> findByProvinceCode(String provinceCode);
}
