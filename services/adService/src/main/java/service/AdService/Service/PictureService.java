package service.AdService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdService.model.Client;
import service.AdService.model.Picture;
import service.AdService.repository.PictureRepo;

@Service
public class PictureService {

    @Autowired
    private PictureRepo pictureRepo;

    public void addPicture(Picture picture){
        pictureRepo.save(picture);
    }
}
