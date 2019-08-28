package com.deskdev.helpdesk.repo;

import com.deskdev.helpdesk.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepo extends JpaRepository<Reply, Long> {
}
