package com.deskdev.helpdesk.repo;

import com.deskdev.helpdesk.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepo extends JpaRepository<Reply, Long> {
    List<Reply> getAllByTopicIDOrderByReplyDateAsc(Long topID);
}
