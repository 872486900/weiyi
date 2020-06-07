package com.example.weiyi.dao;

import com.example.weiyi.entity.City;
import com.example.weiyi.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by 87248 on 2020-06-04 11:44
 */
@Controller
public interface HospitalDao extends JpaRepository<Hospital,Long>{
    @Query("select h from Hospital h where h.cityCode=:cityCode")
    List<Hospital> findByCityCode(String cityCode);

    @Query("select h from Hospital  h where h.Hid=:Hid")
    Hospital findByHid(Long Hid);
}
