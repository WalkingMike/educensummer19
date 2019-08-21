package com.deskdev.helpdesk.model;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "USER")
public class User implements UserDetails {
    @Transient
    private List<Role> authorities;

    @Transient
    private boolean active;

    @Override
    public String getUsername(){
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

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
}