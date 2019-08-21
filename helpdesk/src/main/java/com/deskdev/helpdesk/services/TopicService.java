package com.deskdev.helpdesk.services;

import com.deskdev.helpdesk.model.Topic;
import com.deskdev.helpdesk.repo.TopicRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {
    @Autowired
    private final TopicRepo topicRepo;

    @Transactional
    public List<Topic> getAll(){
        return topicRepo.findAll();
    }

    @Transactional
    public void addTopic(Topic tpc){
        topicRepo.save(tpc);
    }

    @Transactional
    public void removeTopic(Long id){
        topicRepo.deleteById(id);
    }
}