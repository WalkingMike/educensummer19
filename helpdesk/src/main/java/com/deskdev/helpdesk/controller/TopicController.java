package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.Topic;
import com.deskdev.helpdesk.services.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class TopicController {
    @Autowired
    private final TopicService topicService;

    @RequestMapping(value = "/topic/selectall", method = RequestMethod.GET)
    public @ResponseBody List<Topic> selectAll() {
        return topicService.getAll();
    }

    @RequestMapping(value = "/topic/add", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topic/remove", method = RequestMethod.DELETE)
    public void removeTopic(@RequestParam Long id) {
        topicService.removeTopic(id);
    }
}