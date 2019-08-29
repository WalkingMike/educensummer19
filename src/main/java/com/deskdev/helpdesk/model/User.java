package com.deskdev.helpdesk.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USER")
public class User{
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name="register_date")
    private Date registerDate;

    @Column(name = "role_id")
    private Long roleID;

    @Column(name = "region_id")
    private Long regionID;

    @OneToOne
    @JoinColumn(name="role_id", insertable = false, updatable = false)
    private Role role;

    @OneToOne
    @JoinColumn(name="region_id", insertable = false, updatable = false)
    private Region region;
}