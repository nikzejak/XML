package service.AdminService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import service.AdminService.dtos.*;
import service.AdminService.model.*;
import service.AdminService.service.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class AdminController {

    //dodavanje fuel type
    @Autowired
    FuelTypeService fuelTypeService;

    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/fuelType/all")
    public ResponseEntity<List<FuelType>> all() { return new ResponseEntity<>(fuelTypeService.findall(), HttpStatus.OK);}

    @PostMapping(value = "/addFuelType")
    public String addFuelType(@RequestBody FuelTypeDto fuelTypeDto){

        FuelType fuelType = fuelTypeService.getFuelType(fuelTypeDto.getSerialNumber());
        if(fuelType == null){
            FuelType newFuelType = new FuelType();
            newFuelType.setSerial_number(fuelTypeDto.getSerialNumber());
            newFuelType.setType(fuelTypeDto.getType());

            boolean uspesno = fuelTypeService.addFuelType(newFuelType);
            if(uspesno == true){
                System.out.println("New fuel type with id: " + newFuelType.getId() + "is added.");
            }
            else {
                System.out.println("Id already exists: " + newFuelType.getId());
            }
            return "";
        }
        else{
            return "Id already exists";
        }
    }

    //dodavanje transmission type
    @Autowired
    TransmissionTypeService transmissionTypeService;

    @GetMapping(value = "/transmissionType/all")
    public ResponseEntity<List<TransmissionType>> all2() { return new ResponseEntity<>(transmissionTypeService.findall(), HttpStatus.OK);}

    @PostMapping(value = "/addTransmissionType")
    public String addTransmissionType(@RequestBody TransmissionTypeDto transmissionTypeDto){
        System.out.println("back");

        TransmissionType transmissionType = transmissionTypeService.getTransmissionType(transmissionTypeDto.getSerialNumber());
        if (transmissionType == null){

            System.out.println("back1");

            TransmissionType newTransmissionType = new TransmissionType();
            newTransmissionType.setSerialNumber(transmissionTypeDto.getSerialNumber());
            newTransmissionType.setType(transmissionTypeDto.getType());

            boolean uspesno = transmissionTypeService.addTransmissionType(newTransmissionType);
            if(uspesno == true){
                System.out.println("New transmission type with serial: " + newTransmissionType.getSerialNumber() + "is added.");
            }
            else {
                System.out.println("Serial already exists: " + newTransmissionType.getSerialNumber());
            }
            return "";
        }
        else{
            return "Serial already exists";
        }
    }

    //dodavanje car type
    @Autowired
    CarTypeService carTypeService;

    @GetMapping(value = "/carType/all")
    public ResponseEntity<List<CarType>> all3() { return new ResponseEntity<>(carTypeService.findall(), HttpStatus.OK);}

    @PostMapping(value = "/addCarType")
    public String addCarType(@RequestBody CarTypeDto carTypeDto){

        CarType carType = carTypeService.getCarType(carTypeDto.getType());
        if (carType == null){
            CarType newCarType = new CarType();
            newCarType.setType(carTypeDto.getType());

            boolean uspesno = carTypeService.addCarType(newCarType);
            if(uspesno == true){
                System.out.println("New car is added.");
            }
            else {
                System.out.println("Car type already exists: " + newCarType.getType());
            }
            return "";
        }
        else{
            return "Serial already exists";
        }
    }

    //dodavanje car brand
    @Autowired
    CarBrandService carBrandService;

    @GetMapping(value = "/carBrand/all")
    public ResponseEntity<List<CarBrand>> all4() { return new ResponseEntity<>(carBrandService.findall(), HttpStatus.OK);}

    @PostMapping(value = "/addCarBrand")
    public String addCarBrand(@RequestBody CarBrandDto carBrandDto){

        CarBrand carBrand = carBrandService.getCarBrand(carBrandDto.getBrand());
        if (carBrand == null){
            CarBrand newCarBrand = new CarBrand();
            newCarBrand.setBrand(carBrandDto.getBrand());

            boolean uspesno = carBrandService.addCarBrand(newCarBrand);
            if(uspesno == true){
                System.out.println("New car brand is added.");
            }
            else {
                System.out.println("Car brand already exists: " + newCarBrand.getBrand());
            }
            return "";
        }
        else{
            return "Serial already exists";
        }
    }

    //dodavanje car model
    @Autowired
    CarModelService carModelService;

    @GetMapping(value = "/carModel/all")
    public ResponseEntity<List<CarModel>> all5() { return new ResponseEntity<>(carModelService.findall(), HttpStatus.OK);}

    @PostMapping(value = "/addCarModel")
    public String addCarModel(@RequestBody CarModelDto carModelDto){

        CarModel carModel = carModelService.getCarModel(carModelDto.getModel());
        if (carModel == null){
            CarModel newCarModel = new CarModel();
            newCarModel.setModel(carModelDto.getModel());

            boolean uspesno = carModelService.addCarModel(newCarModel);
            if(uspesno == true){
                System.out.println("New car model is added.");
            }
            else {
                System.out.println("Car model already exists: " + newCarModel.getModel());
            }
            return "";
        }
        else{
            return "Serial already exists";
        }
    }

    @PostMapping(value = "/brandOperation")
    public ResponseEntity<CarBrand> operations(@RequestParam(value = "operation", required = true) String operation,
                                           @RequestParam(value = "brand", required = true) String brand) {

        //Long lid = Long.parseLong(id);
        String br = new String(brand);
        CarBrand brando = carBrandService.findCarBrandByBrand(brand);
        if(operation.equals("REMOVED")){
            carBrandService.deleteCarBrand(brando);
            return new ResponseEntity<> (brando, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(brando, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/addAgent")
    public ResponseEntity<Client> addAgent(@RequestBody AddAgentDto addAgentDto) {
        Client client = clientService.findClientByEmail(addAgentDto.getEmail());
        if(client == null) {
            client = new Client(addAgentDto.getEmail(), addAgentDto.getPassword(), addAgentDto.getFirstName(), addAgentDto.getLastName(), addAgentDto.getJmbg(), addAgentDto.getPhoneNumber(), addAgentDto.getAddress(), addAgentDto.getPersonalID());
            clientService.addClient(client);
            User user = new User();
            user.setEmail(addAgentDto.getEmail());
            user.setPassword(addAgentDto.getPassword());
            user.setRole(Role.AGENT);
            user.setStatus(UserStatus.ACCEPTED);
            userService.save(user);
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }

    }

    @PostMapping(value = "/addFirm")
    public ResponseEntity<Client> addFirm(@RequestBody AddFirmDto addFirmDto) {
        Client client = clientService.findClientByEmail(addFirmDto.getEmail());
        if(client == null) {
            client = new Client(addFirmDto.getEmail(), addFirmDto.getPassword(), addFirmDto.getFirstName(), addFirmDto.getPhoneNumber(), addFirmDto.getAddress(), addFirmDto.getPib());
            clientService.addClient(client);
            User user = new User();
            user.setEmail(addFirmDto.getEmail());
            user.setPassword(addFirmDto.getPassword());
            user.setRole(Role.FIRM);
            user.setStatus(UserStatus.ACCEPTED);
            userService.save(user);
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }

    }

    @GetMapping(value = "/permissionsClients")
    public ResponseEntity<List<Client>> clientsPermissions() {
        List<Client> ret = new ArrayList<>();
        List<User> list = userService.findAllEndUsers();
        for(User u : list) {
            Client c = clientService.findClientByEmail(u.getEmail());
            if(c != null) {
                ret.add(c);
            }
        }
        return new ResponseEntity<>(ret , HttpStatus.OK);
    }


}
