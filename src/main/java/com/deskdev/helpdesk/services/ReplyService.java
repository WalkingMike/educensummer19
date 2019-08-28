package com.deskdev.helpdesk.services;

import com.deskdev.helpdesk.model.Reply;
import com.deskdev.helpdesk.repo.ReplyRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ReplyService {
    @Autowired
    private final ReplyRepo replyRepo;

    @Transactional
    public List<Reply> getAll(){
        return replyRepo.findAll(new Sort(Sort.Direction.ASC, "replyDate"));
    }

    @Transactional
    public void addReply(Reply rply){
        replyRepo.save(rply);
    }

    @Transactional
    public void removeReply(Long id){
        replyRepo.deleteById(id);
    }
}
