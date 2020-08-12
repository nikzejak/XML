package com.agent.backend.controller;

import com.agent.backend.model.CarType;
import com.agent.backend.services.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class CarTypeController {

    @Autowired
    CarTypeService carTypeService;

    @GetMapping(value = "/carType/all")
    public ResponseEntity<List<CarType>> all3() { return new ResponseEntity<>(carTypeService.findall(), HttpStatus.OK);}

}
