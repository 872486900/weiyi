package com.example.weiyi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 87248 on 2020-06-01 17:23
 */
@Entity
@Table(name = "t_hospital")
public class Hospital implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Hid;
    private String Hname;
    private String Hlevel;//级别
    private String Haddress;
    private String Htel;
    private String Hintroduction;//医院的简介
    private String Hphoto;
    private String cityCode;//所在城市


    @OneToMany(mappedBy = "hospital",fetch = FetchType.LAZY)
    private List<Doctor> doctors=new ArrayList<>();

    public Hospital() {
    }

    public Long getHid() {
        return Hid;
    }

    public void setHid(Long hid) {
        Hid = hid;
    }

    public String getHname() {
        return Hname;
    }

    public void setHname(String hname) {
        Hname = hname;
    }

    public String getHlevel() {
        return Hlevel;
    }

    public void setHlevel(String hlevel) {
        Hlevel = hlevel;
    }

    public String getHaddress() {
        return Haddress;
    }

    public void setHaddress(String haddress) {
        Haddress = haddress;
    }

    public String getHtel() {
        return Htel;
    }

    public void setHtel(String htel) {
        Htel = htel;
    }

    public String getHintroduction() {
        return Hintroduction;
    }

    public void setHintroduction(String hintroduction) {
        Hintroduction = hintroduction;
    }

    public String getHphoto() {
        return Hphoto;
    }

    public void setHphoto(String hphoto) {
        Hphoto = hphoto;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
