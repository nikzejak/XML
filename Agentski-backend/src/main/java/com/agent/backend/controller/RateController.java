package com.agent.backend.controller;

import com.agent.backend.model.Comment;
import com.agent.backend.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class RateController {

    @Autowired
    RateService rateService;

    @GetMapping(value = "renting/RateAndComment")
    public ResponseEntity<List<Comment>> allCommentsForOperation() {
        System.out.println("dosao na back");
        List<Comment> pom = rateService.findAll();
        List<Comment> ret = new ArrayList<>();

        for(Comment c : pom) {
            if(c.isApproved()) {
                ret.add(c);
                System.out.println(c.toString());
            }
        }
        System.out.println("dosao na back posle fora");

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
