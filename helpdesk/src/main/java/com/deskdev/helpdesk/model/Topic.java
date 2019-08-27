package com.deskdev.helpdesk.model;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

    @Column(length = 1000)
    private String content;

    @Column(name="topic_date")
    private Date topicDate;

    @Column(name="creator_id")
    private Long creatorID;

    @Column(name="region_id")
    private Long regionID;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private User creator;

    //@JsonIgnore
    @OneToOne
    @JoinColumn(name="region_id", insertable = false, updatable = false)
    private Region region;
}

