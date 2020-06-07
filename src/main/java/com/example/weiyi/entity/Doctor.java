package com.example.weiyi.entity;

import lombok.*;

import java.util.List;
import javax.persistence.*;
import java.util.ArrayList;
/**
 * Created by 87248 on 2020-06-01 17:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "orderList")
@Entity
@Table(name = "t_doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;
    private String Dname;
    private String Dtel;
    private String sex;
    private String cardtype;
    private String cardid;
    private String pwd;
    private String Daddress;
    private String Dgood;//擅长
    private String Dphoto;//图片
    private String Dintroduction;//简介
    private String Dfei;//问诊费用
    private String Dren;//认证图片，医生证
    @ManyToOne
    private Type type;
    @ManyToOne
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private List<Order> orderList=new ArrayList<>();

}
