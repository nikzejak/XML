package com.agent.backend.repository;


import com.agent.backend.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PictureRepo extends JpaRepository<Picture, Long> {

}
