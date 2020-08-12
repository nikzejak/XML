package com.agent.backend.services;

import com.agent.backend.model.Picture;
import com.agent.backend.repository.PictureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PictureService {

    @Autowired
    private PictureRepo pictureRepo;

    public void addPicture(Picture picture){
        pictureRepo.save(picture);
    }
}
