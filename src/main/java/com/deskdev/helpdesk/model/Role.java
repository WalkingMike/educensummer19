package com.deskdev.helpdesk.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ROLE")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    @Column(name="role_id")
    private Long id;

    @Column(name="role_description")
    private String roleDescription;

    @Override
    public String getAuthority() {
        return roleDescription;
    }
}
