package com.example.weiyi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 87248 on 2020-06-03 17:18
 */
//预约挂号单

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Oid;
    private String Ojy;
    private String Otime;
    private String Ointroduction;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;
    @ManyToOne
    private User user;
    @ManyToOne
    private Doctor doctor;


}
