package com.deskdev.helpdesk.controller;

import com.deskdev.helpdesk.model.Reply;
import com.deskdev.helpdesk.services.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class ReplyController {
    @Autowired
    private final ReplyService replyService;

    @GetMapping(value = "/reply/selectall")
    public @ResponseBody List<Reply> selectAll() {
        return replyService.getAll();
    }

    @GetMapping(value = "/reply/selectall/topic")
    public @ResponseBody List<Reply> selectAll(@RequestParam Long id) {
        return replyService.getAllByTopic(id);
    }

    @PostMapping(value = "/reply/add")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    public void addReply(@RequestBody Reply reply) {
        replyService.addReply(reply);
    }

    @DeleteMapping(value = "/reply/remove")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    public void removeReply(@RequestParam Long id) {
        replyService.removeReply(id);
    }
}