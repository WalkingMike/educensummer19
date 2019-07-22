package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.Reply;
import com.deskdev.helpdesk.services.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class ReplyController {
    @Autowired
    private final ReplyService replyService;

    @RequestMapping(value = "/reply/selectall", method = RequestMethod.GET)
    public @ResponseBody List<Reply> selectAll() {
        return replyService.getAll();
    }

    @RequestMapping(value = "/reply/add", method = RequestMethod.POST)
    public void addReply(@RequestBody Reply reply) {
        replyService.addReply(reply);
    }

    @RequestMapping(value = "/reply/remove", method = RequestMethod.DELETE)
    public void removeReply(@RequestParam Long id) {
        replyService.removeReply(id);
    }
}