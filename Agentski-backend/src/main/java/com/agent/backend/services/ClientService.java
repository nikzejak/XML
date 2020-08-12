package com.agent.backend.services;

import com.agent.backend.model.Client;
import com.agent.backend.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    @Autowired
    ClientRepo clientRepo;

    public void addClient(Client client){
        clientRepo.save(client);
    }

    public Client findClientByID(Long id){
        return clientRepo.findClientById(id);
    }

    public Client findClientByEmail(String email) {
        return clientRepo.findClientByEmail(email);
    }
    public void save(Client c) {
        clientRepo.save(c);
    }
}
