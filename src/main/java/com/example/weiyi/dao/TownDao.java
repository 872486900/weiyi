package com.example.weiyi.dao;

import com.example.weiyi.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by 87248 on 2020-06-04 15:12
 */
public interface TownDao extends JpaRepository<Town,Integer> {
    @Query("select t from Town t where t.CityCode=:cityCode")
    List<Town> findByCityCode(String cityCode);
}
