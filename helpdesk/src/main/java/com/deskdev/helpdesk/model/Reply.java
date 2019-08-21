package com.deskdev.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Column(name="author_id")
    private Long authorID;

    @Column(name="topic_id")
    private Long topicID;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private User author;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="topic_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Topic topic;
}
