package com.agent.backend.repository;


import com.agent.backend.model.Message;
import com.agent.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findAll();
    List<Message> findAllByReceiver(User receiver);
    List<Message> findAllBySender(User sender);
    Message findMessageById(Long id);
}
