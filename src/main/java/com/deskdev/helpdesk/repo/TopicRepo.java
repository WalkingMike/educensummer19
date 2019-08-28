package com.deskdev.helpdesk.repo;

import com.deskdev.helpdesk.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TopicRepo extends JpaRepository<Topic, Long> {
    List<Topic> findAllByRegionIDOrderByTopicDateDesc(Long id);
}
