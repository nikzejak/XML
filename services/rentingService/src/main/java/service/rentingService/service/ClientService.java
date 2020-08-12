package service.rentingService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.rentingService.model.Ad;
import service.rentingService.model.Client;
import service.rentingService.repository.ClientRepo;

import java.util.List;
import java.util.Set;


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

    public Client findClientByAd(Ad ad){
        List<Client> cls = clientRepo.findAll();
    //    System.out.println(cls);
        if(cls!=null){
        for(Client c:cls){
            Set<Ad> ads=c.getAds();
        //    System.out.println(ads);
            if(ads!=null){
            for(Ad a:ads){
                if(ad.getId()==a.getId()){
                    return c;
                }
            }
            }else {
                return null;
            }
        }
        return null;
    }
    return null;}

}
