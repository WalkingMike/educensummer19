package com.deskdev.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USER")
public class User {
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

    //@JsonIgnore
    @OneToOne
    @JoinColumn(name="role_id", referencedColumnName = "role_id")
    private Role role;

    //@JsonIgnore
    @OneToOne
    @JoinColumn(name="region_id", referencedColumnName = "region_id")
    private Region region;
}