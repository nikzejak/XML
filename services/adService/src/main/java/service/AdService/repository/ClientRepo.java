package service.AdService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.AdService.model.Client;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client, Long> {

    List<Client> findAll();

    Client findClientById(Long id);
    Client findClientByEmail(String email);

}
