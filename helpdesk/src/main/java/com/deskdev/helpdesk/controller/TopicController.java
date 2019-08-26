package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.Topic;
import com.deskdev.helpdesk.services.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class TopicController {
    @Autowired
    private final TopicService topicService;

    @GetMapping(value = "/topic/selectall")
    public @ResponseBody List<Topic> selectAll() {
        return topicService.getAll();
    }

    @GetMapping(value = "/topic/selectall/region")
    public @ResponseBody List<Topic> selectAllByRegionID(@RequestParam Long id) {
        return topicService.getAllByRegion(id);
    }

    @PostMapping(value = "/topic/add")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @DeleteMapping(value = "/topic/remove")
    public void removeTopic(@RequestParam Long id) {
        topicService.removeTopic(id);
    }
}