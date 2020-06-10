package com.example.weiyi.dao;

import com.example.weiyi.entity.Doctor;
import com.example.weiyi.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by 87248 on 2020-06-01 18:21
 */
public interface DoctorDao extends JpaRepository<Doctor,Long> {

    @Query("select d from Doctor d where d.hospital=:hospital")
    Page<Doctor> findByHospital(Hospital hospital, Pageable pageable);

    @Query("select d from Doctor d where d.Dtel=:Dtel and d.pwd=:pwd")
    Doctor findByDtelAndPwd(String Dtel,String pwd);

}
