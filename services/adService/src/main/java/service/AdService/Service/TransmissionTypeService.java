package service.AdService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdService.model.TransmissionType;
import service.AdService.repository.TransmissionTypeRepo;


import java.util.List;

@Service
public class TransmissionTypeService {

    @Autowired
    TransmissionTypeRepo transmissionTypeRepo;

    public List<TransmissionType> findall() { return transmissionTypeRepo.findAll(); }

    public TransmissionType findTransByType(String type) { return transmissionTypeRepo.findTransmissionTypeByType(type);}

    public TransmissionType save(TransmissionType t) { return transmissionTypeRepo.save(t);}


}
