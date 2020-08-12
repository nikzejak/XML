package service.AdminService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdminService.model.Client;
import service.AdminService.repository.ClientRepo;


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
    public void deleteClient(Client c) {
        clientRepo.delete(c);
    }
}
