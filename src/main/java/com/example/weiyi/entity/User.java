package com.example.weiyi.entity;


import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 87248 on 2020-05-30 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "orders")
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long usid;

    private String uname;
    private String sex;
    private String cardtype;
    private String cardid;
    private String pwd;
    private String address;
    private String email;
    private String photo;
    private String tel;
    @OneToMany(mappedBy = "user")
    private List<Order> orders=new ArrayList<>();


}
