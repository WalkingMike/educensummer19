package com.deskdev.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "REPLY")
public class Reply {
    @Id
    @GeneratedValue
    @Column(name="reply_id")
    private Long id;

    @Column(name="reply_text")
    private String replyText;

    @Column(name="reply_date")
    private Date replyDate;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "user_id", nullable = false)
    private User author;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name="topic_id", referencedColumnName = "topic_id")
    private Topic topic;
}
