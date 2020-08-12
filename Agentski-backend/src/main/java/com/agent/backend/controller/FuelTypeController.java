package com.agent.backend.controller;

import com.agent.backend.model.FuelType;
import com.agent.backend.services.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class FuelTypeController {

    @Autowired
    FuelTypeService fuelTypeService;

    @GetMapping(value = "/fuelType/all")
    public ResponseEntity<List<FuelType>> all() { return new ResponseEntity<>(fuelTypeService.findall(), HttpStatus.OK);}

}
