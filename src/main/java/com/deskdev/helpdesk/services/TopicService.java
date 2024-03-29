package com.deskdev.helpdesk.services;

import com.deskdev.helpdesk.model.Topic;
import com.deskdev.helpdesk.repo.TopicRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {
    @Autowired
    private final TopicRepo topicRepo;

    @Transactional
    public List<Topic> getAll(){
        return topicRepo.findAll(new Sort(Sort.Direction.DESC, "topicDate"));
    }

    @Transactional
    public List<Topic> getAllByRegion(Long id){
        return topicRepo.findAllByRegionIDOrderByTopicDateDesc(id);
    }

    @Transactional
    public String getTopicContent(Long id){
        Topic topic = topicRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        return topic.getContent();
    }

    @Transactional
    public void setTopicContent(Long id, String content){
        Topic topic = topicRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        topic.setContent(content);
        topicRepo.save(topic);
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
