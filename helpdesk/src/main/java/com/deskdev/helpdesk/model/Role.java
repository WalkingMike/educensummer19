package com.deskdev.helpdesk.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue
    @Column(name="role_id")
    private Long id;

    @Column(name="role_description")
    private String roleDescription;
}
