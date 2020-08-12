package com.agent.backend.controller;

import com.agent.backend.model.TransmissionType;
import com.agent.backend.services.TransmissionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class TransmissionTypeController {

    @Autowired
    TransmissionTypeService transmissionTypeService;

    @GetMapping(value = "/transmissionType/all")
    public ResponseEntity<List<TransmissionType>> all2() { return new ResponseEntity<>(transmissionTypeService.findall(), HttpStatus.OK);}
}
