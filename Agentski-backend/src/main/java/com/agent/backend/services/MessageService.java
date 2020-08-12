package com.agent.backend.services;


import com.agent.backend.model.Message;
import com.agent.backend.model.User;
import com.agent.backend.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public Message findById(Long id) { return messageRepo.findMessageById(id); }

    public List<Message> findall() {return messageRepo.findAll();}

    public Message save(Message f) { return messageRepo.save(f);}

    public List<Message> findAllBySender(User sender){
        return messageRepo.findAllBySender(sender);
    }

    public List<Message> findAllByReceiver(User receiver){
        return messageRepo.findAllByReceiver(receiver);
    }
}
