package com.deskdev.helpdesk.model;

import lombok.*;

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

    @Column(name = "role_id")
    private Long roleID;

    @Column(name = "region_id")
    private Long regionID;

    //@JsonIgnore
    @OneToOne
    @JoinColumn(name="role_id", nullable = false, insertable = false, updatable = false)
    private Role role;

    //@JsonIgnore
    @OneToOne
    @JoinColumn(name="region_id", nullable = false, insertable = false, updatable = false)
    private Region region;

    public User() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

}