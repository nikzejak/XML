package service.rentingService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import service.rentingService.model.RentRequest;
import service.rentingService.model.RentRequestStatus;
import service.rentingService.repository.RentRequestRepo;

import javax.sound.midi.SysexMessage;
import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableScheduling
public class RentRequestService {

    @Autowired
    RentRequestRepo rentRequestRepo;

    public void addRent(RentRequest rent){
        rentRequestRepo.save(rent);
    }

    public List<RentRequest> findAll() {
        return rentRequestRepo.findAll();
    }

    public List<RentRequest> findAllByClientId(Long id) {
        return rentRequestRepo.findAllByClientId(id);
    }
    public RentRequest findById(Long id) {
        return rentRequestRepo.findRentRequestById(id);
    }


    @Scheduled(cron = "*/10 * * * * *")
    public void setStatus() {
        List<RentRequest> tmp = findAll();
        if(tmp.isEmpty()) {
            return;
        } else {
            for(RentRequest r : tmp) {
                LocalDateTime localDateTime = r.getTimeCreated().plusDays(1);
                // LocalDateTime localDateTime = r.getTimeCreated().plusMinutes(27);
                LocalDateTime now = LocalDateTime.now();
                if(localDateTime.isBefore(now) && r.getRentRequestStatus() == RentRequestStatus.PENDING) {
                    r.setRentRequestStatus(RentRequestStatus.CANCELED);
                    rentRequestRepo.save(r);
                }
            }
        }

    }
}
