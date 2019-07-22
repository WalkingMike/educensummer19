package com.deskdev.helpdesk.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "REGION")
public class Region {
    @Id
    @GeneratedValue
    @Column(name = "region_id")
    private Long id;

    @Column(unique = true)
    private String region;
}