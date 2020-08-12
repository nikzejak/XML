package service.rentingService.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import service.rentingService.model.Ad;
import service.rentingService.model.Client;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client, Long> {

    List<Client> findAll();

    Client findClientById(Long id);
    Client findClientByEmail(String email);
    Client findClientByAds(Ad ad);
}
