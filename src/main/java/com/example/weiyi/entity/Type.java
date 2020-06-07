package com.example.weiyi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 87248 on 2020-06-01 16:52
 */
//疾病
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "doctors")
@Entity
@Table(name = "t_type")
public class  Type{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Tid;
    private String Tname;

    @OneToMany(mappedBy = "type")
    private List<Doctor> doctors=new ArrayList<>();



}
