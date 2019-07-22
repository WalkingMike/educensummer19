package com.deskdev.helpdesk.repo;

import com.deskdev.helpdesk.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepo extends JpaRepository<Topic, Long> {
}
