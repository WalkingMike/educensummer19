package com.deskdev.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "TOPIC")
public class Topic {
    @Id
    @GeneratedValue
    @Column(name="topic_id")
    private Long id;

    @Column
    private String subject;

    @Column
    private String content;

    @Column(name="topic_date")
    private Date topicDate;

    @Column(name="creator_id")
    private Long creatorID;

    @Column(name="region_id")
    private Long regionID;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name="creator_id", insertable = false, updatable = false)
    private User creator;

    //@JsonIgnore
    @OneToOne
    @JoinColumn(name="region_id", insertable = false, updatable = false)
    private Region region;
}

