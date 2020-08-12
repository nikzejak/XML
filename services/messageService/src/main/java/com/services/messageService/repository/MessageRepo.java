package com.services.messageService.repository;

import com.services.messageService.model.Message;
import com.services.messageService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findAll();
    List<Message> findAllByReceiver(User receiver);
    List<Message> findAllBySender(User sender);
}
