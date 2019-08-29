package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.Topic;
import com.deskdev.helpdesk.services.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping(value = "/topic/content")
    public @ResponseBody String getTopicContent(@RequestParam Long id) {
        return topicService.getTopicContent(id);
    }

    @PostMapping(value = "/topic/add")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @PutMapping(value = "/topic/modifycontent")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    public void modifyUserRole(@RequestParam Long id, @RequestParam String content) {
        topicService.setTopicContent(id, content);
    }

    @DeleteMapping(value = "/topic/remove")
    public void removeTopic(@RequestParam Long id) {
        topicService.removeTopic(id);
    }
}