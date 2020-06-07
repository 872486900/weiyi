package com.example.weiyi.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by 87248 on 2020-06-04 14:54
 */
@Data
@Entity
@Table(name = "t_address_town")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "code")
    private String Code;
    @Column(name = "name")
    private String Name;
    @Column(name = "cityCode")
    private String CityCode;

}
