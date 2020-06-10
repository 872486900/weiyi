package com.example.weiyi.dao;

import com.example.weiyi.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * Created by 87248 on 2020-06-08 12:35
 */
public interface AdminDao extends JpaRepository<Admin,Long> {
    @Query("select a from Admin a where a.Atel=:Atel and a.password=:password")
    Admin findByAtelAndPassword(String Atel,String password);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Admin a set a.Adate=?2 where a.Aid=?1")
    int update(Long aid, Date adate);



}
