package com.agent.backend.repository;

import com.agent.backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ClientRepo extends JpaRepository<Client, Long> {

    List<Client> findAll();

    Client findClientById(Long id);
    Client findClientByEmail(String email);

}
