package com.example.weiyi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 87248 on 2020-06-08 12:32
 */
@Data
@Entity
@Table(name = "t_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Aid;
    private String Atel;
    private String Aname;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date Adate; //最近登录时间
}
