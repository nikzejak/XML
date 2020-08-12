package service.rentingService.controller;

import org.joda.time.DateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.rentingService.dtos.*;
import service.rentingService.model.*;
import service.rentingService.service.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class RentRequestController {
    @Autowired
    RentRequestService rentRequestService;

    @Autowired
    ClientService clientService;

    @Autowired
    AdService adService;

    @Autowired
    CommentService commentService;

    @Autowired
    CarService carService;

    @Autowired
    CartService cartService;

    @GetMapping("/rentRequestsForUser")
    public ResponseEntity<List<RentRequest>> requestsForUsers(@RequestParam(value = "email", required = true) String email) {
        Client c = clientService.findClientByEmail(email);
        List<RentRequest> tmp = new ArrayList<>();
        List<RentRequest> ret = rentRequestService.findAll();
        for(RentRequest r : ret) {
            for(Car car : r.getCarsForRent()) {
                List<Ad> ads = adService.findAllByCarId(car.getId());
                for(Ad a : ads) {
                    if(a.getClient().getId() == c.getId()) {
                        tmp.add(r);
                    }
                }
            }
        }
        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity reserve(@RequestBody SendDTO sendDTO){
        RentRequest rr = new RentRequest();
        Set<Car> carsForRent= new HashSet<>();
        Ad ad=sendDTO.getAdWithTimes().getAd();
        DateTime startD = DateTime.parse(sendDTO.getAdWithTimes().getStartTime());
        DateTime endD = DateTime.parse(sendDTO.getAdWithTimes().getEndTime());
        if(ad.getStartOfAd().before(startD.toDate()) && ad.getEndOfAd().after(endD.toDate())) {
            carsForRent.add(sendDTO.getAdWithTimes().getAd().getCar());
            rr.setCarsForRent(carsForRent);
            System.out.println(sendDTO.toString());
            // rr.getCarsForRent().add(sendDTO.getAdWithTimes().getAd().getCar());
            rr.setClient(clientService.findClientByEmail(sendDTO.getEmail()));
            rr.setReservedFrom(startD.toDate());
            rr.setReservedTo(endD.toDate());
            rr.setRentRequestStatus(RentRequestStatus.PENDING);
            rr.setTimeCreated(LocalDateTime.now());

            System.out.println(rr.getTimeCreated().toString());
            Client client =clientService.findClientByEmail(sendDTO.getEmail());
            if(client.isAllowReservation() == true) {
                rentRequestService.addRent(rr);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/reserveMy")
    public ResponseEntity reserveMy(@RequestBody SendDTO sendDTO){
        RentRequest rm = new RentRequest();
        Set<Car> carsForRentM= new HashSet<>();
        Ad ad=sendDTO.getAdWithTimes().getAd();
        DateTime startD = DateTime.parse(sendDTO.getAdWithTimes().getStartTime());
        DateTime endD = DateTime.parse(sendDTO.getAdWithTimes().getEndTime());
        if(ad.getStartOfAd().before(startD.toDate()) && ad.getEndOfAd().after(endD.toDate())) {
            carsForRentM.add(sendDTO.getAdWithTimes().getAd().getCar());
            rm.setCarsForRent(carsForRentM);
            System.out.println(sendDTO.toString());
            // rr.getCarsForRent().add(sendDTO.getAdWithTimes().getAd().getCar());
            rm.setClient(clientService.findClientByEmail(sendDTO.getEmail()));
            rm.setReservedFrom(startD.toDate());
            rm.setReservedTo(endD.toDate());
            rm.setRentRequestStatus(RentRequestStatus.RESERVED);
            rm.setTimeCreated(LocalDateTime.now());

            System.out.println(rm.getTimeCreated().toString());
            rentRequestService.addRent(rm);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/allFilter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ad>> login(@RequestBody AdFilterDTO addto)
    {
        DateTime startD = DateTime.parse(addto.getStartDate());
        DateTime endD = DateTime.parse(addto.getEndDate());
        List<Ad> lista=adService.findAll();
        List<Ad> pom=new ArrayList<>();
        List<Ad> ret= new ArrayList<>();
        for (Ad a:lista) {
            // if(a.getId() != addto.getId())
            if(a.getPlace().equals(addto.getPlace())){
                if(startD.toDate().after(a.getStartOfAd())){
                    if(endD.toDate().before(a.getEndOfAd())){
                        pom.add(a);
                        ret.add(a);
                    }
                }
            }
        }


        List<RentRequest> rent_list = rentRequestService.findAll();


        if(rent_list.size() != 0) {
            for(RentRequest r : rent_list) {
                for(Car c : r.getCarsForRent()) {
                    Ad ad = adService.findAdByCarId(c.getId());
                    for(Ad a: ret) {
                        if(a.getCar().getId() == c.getId()) {
                            System.out.println(startD.toDate());
                            System.out.println(endD.toDate());
                            System.out.println(r.getReservedFrom());
                            System.out.println(r.getReservedTo());
                            if(r.getReservedFrom().after(startD.toDate()) && r.getReservedTo().before(endD.toDate())) {
                                pom.remove(a);
                            } else if (r.getReservedFrom().after(startD.toDate()) && r.getReservedTo().after(endD.toDate()) && r.getReservedFrom().before(endD.toDate())) {
                                pom.remove(a);
                            } else if (r.getReservedFrom().before(startD.toDate()) && r.getReservedTo().before(endD.toDate()) && r.getReservedTo().after(startD.toDate())) {
                                pom.remove(a);
                            }
                        }
                    }
                }
            }
        }
        return new ResponseEntity<>(pom, HttpStatus.OK);
    }

    @PostMapping(value = "/rentOperation")
    public ResponseEntity<RentRequest> operations(@RequestParam(value = "operation", required = true) String operation,
                                           @RequestParam(value = "id", required = true) String id) {

        Long lid = Long.parseLong(id);
        RentRequest rentRequest = rentRequestService.findById(lid);
        if(operation.equals("АCCEPTED")) {
            rentRequest.setRentRequestStatus(RentRequestStatus.RESERVED);
            rentRequestService.addRent(rentRequest);
            return new ResponseEntity<>(rentRequest, HttpStatus.OK);
        } else if(operation.equals("DECLINED")) {
            rentRequest.setRentRequestStatus(RentRequestStatus.CANCELED);
            rentRequestService.addRent(rentRequest);
            return new ResponseEntity<>(rentRequest, HttpStatus.OK);
        }

        return new ResponseEntity<>(rentRequest, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/userRentedAds")
    public ResponseEntity<List<RentRequest>> userRentedAds(@RequestParam(value = "email", required = true) String email) {
        Client c = clientService.findClientByEmail(email);
        List<RentRequest> ret = rentRequestService.findAllByClientId(c.getId());
        List<RentRequest> tmp = new ArrayList<>();
        if(ret.isEmpty()) {
            return new ResponseEntity<>(tmp, HttpStatus.BAD_REQUEST);
        }
        else {
            for (RentRequest r : ret) {
                //Ovde treba da status bude PAID
                if (r.getRentRequestStatus() == RentRequestStatus.RESERVED) {
                    tmp.add(r);
                }
            }
        }
        return new ResponseEntity<>(tmp, HttpStatus.OK);

    }

    @GetMapping("/rateCarFlag")
    public ResponseEntity<Boolean> rateCarFlag(@RequestParam(value = "reservedTo", required = true) String reservedTo) {
        boolean flag = false;
        String tmp = reservedTo.substring(0, reservedTo.length() - 6);
        System.out.println(tmp);
        DateTime rto = DateTime.parse(tmp);
        DateTime now = DateTime.now();
        System.out.println(rto.toString());
        System.out.println(now.toString());
        if(now.isAfter(rto)) {
            flag = true;
        }
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }

    @PostMapping("/addComment")
    public ResponseEntity<Comment> addComment(@RequestBody AddCommentDTO addCommentDTO) {
        //OSTALO JE JOS OCENA ZA AUTO
        Comment c = new Comment();
        c.setApproved(addCommentDTO.getComment().isApproved());
        c.setComment(addCommentDTO.getComment().getComment());
        c.setCommenter(addCommentDTO.getComment().getCommenter());
        c.setCarRating(addCommentDTO.getRate());
        Ad ad = adService.findAdByCar(addCommentDTO.getCar());
        c.setAd(ad);
        commentService.addComment(c);

        List<Comment> tmp = commentService.findAllByCar(addCommentDTO.getCar());
        int i = 0;
        double average = 0;
        Car car = ad.getCar();
        for(Comment comment : tmp) {
            average = average + comment.getCarRating();
            i++;
        }

        car.setAverageRating(average / i);
        carService.addCar(car);


        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping(value = "/allAdvanced", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ad>> adAdvanced(@RequestBody AdAdvancedDTO addto)
    {
        System.out.println(addto.toString());
        if(addto.getAds()==null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        List<Ad> lista=addto.getAds();
        List<Ad> pom=new ArrayList<>();
        List<Ad> ret= new ArrayList<>();
        System.out.println(ret);
        ret=addto.getAds();

                if(ret!=null)
                    if(addto.getCarModel()!=""){
                       for(Ad a:lista){
                           if(!addto.getCarModel().equals(a.getCar().getCarModel().getModel())){
                             ret.remove(a);
                           }
                       }
                }
                if(ret!=null)
                if(addto.getCarBrand()!=""){
                    for(Ad r:ret){
                        if(!addto.getCarBrand().equals(r.getCar().getCarBrand().getBrand())){
                            ret.remove(r);
                        }
                    }
                }
                if(ret!=null)
                    if(addto.getCarType()!="") {
                        for (Ad r : ret) {
                            if (!addto.getCarType().equals(r.getCar().getCarType().getType())) {
                                ret.remove(r);
                            }
                        }
                    }
                if(ret!=null)
                    if(addto.getFuelType()!=""){
                        for(Ad r:ret) {
                          if (!addto.getFuelType().equals(r.getCar().getFuelType().getType())) {
                                ret.remove(r);
                            }
                        }
                    }
                if(ret!=null)
                    if(addto.getTransmissionType()!=""){
                        for(Ad r:ret) {
                            if (!addto.getTransmissionType().equals(r.getCar().getTransmissionType().getType())) {
                                ret.remove(r);
                            }
                        }
                    }

//                if(ret!=null)
//                    if(addto.getPrice()!=null){
//                        for(Ad r:ret) {
//                            if (addto.getPrice().intValue()>r.getCar().getPrice()) {
//                                ret.remove(r);
//                            }
//                        }
//                    }
//                if(ret!=null)
//                    if(addto.getPrice2()!=null){
//                        for(Ad r:ret) {
//                            if (addto.getPrice2().intValue()<r.getCar().getPrice()) {
//                                ret.remove(r);
//                            }
//                        }
//                    }

                if(ret!=null)
                    if(addto.getCdw()!=null){
                        for(Ad r:ret) {
                            if (!addto.getCdw().equals(r.getCar().isCollisionDamageWaiver())) {
                                ret.remove(r);
                            }
                        }
                    }
                if(ret!=null)
                    if(addto.getChildSeat()!=null){
                        for(Ad r:ret) {
                            if (addto.getChildSeat().intValue()==r.getCar().getChildSeats()) {
                                ret.remove(r);
                            }
                        }
                    }
                if(ret!=null)
                    if(addto.getMileage()!=null){
                        for(Ad r:ret) {
                            if (addto.getMileage().intValue()==r.getCar().getMileage()) {
                                ret.remove(r);
                            }
                        }
                    }
                if(ret!=null)
                    if(addto.getDistanceAllowed()!=null){
                        for(Ad r:ret) {
                            if (addto.getDistanceAllowed().intValue()==r.getCar().getDistanceAllowed()) {
                                ret.remove(r);
                            }
                        }
                    }
              return new ResponseEntity<>(ret, HttpStatus.OK);
   }

    @PostMapping(value = "/allOwners", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OwnersAndAdsDTO>> adOwners(@RequestBody List<AdRentDTO> addtos){
            List<AdRentDTO> lista=addtos;
            List<Client> cls=new ArrayList<>();
            List<OwnersAndAdsDTO> owsa=new ArrayList<>();
            int flag=0;
            int flag1=0;
        System.out.println("metoda");
            for(AdRentDTO a:lista){
                Client c=clientService.findClientByAd(a.getAd());
              //  System.out.println(c);
                for(OwnersAndAdsDTO o:owsa){
                    if(o.getClient().getId()==c.getId()){
                        flag=1;
                        o.getAds().add(a);
                        break;
                    }
                }
                if(flag==1){
                     flag=0;
                    System.out.println("usao sam 2");
                }else{
                    OwnersAndAdsDTO os=new OwnersAndAdsDTO();
                    os.setClient(c);
                    os.getAds().add(a);
                    owsa.add(os);
                    System.out.println("usao sam 3");
                }
            }
            System.out.println(owsa.size());
            List<OwnersAndAdsDTO> adss=new ArrayList<>();
            int flag2=0;
            for(OwnersAndAdsDTO owa:owsa){
                System.out.println(owa.getAds());
                for(int i=0;i<owa.getAds().size()-1;i++){
                    for(int j=1;j<owa.getAds().size();j++){
                        System.out.println(DateTime.parse(owa.getAds().get(i).getStartTime()).toDate());
                        System.out.println(DateTime.parse(owa.getAds().get(j).getStartTime()).toDate());
                        System.out.println(DateTime.parse(owa.getAds().get(i).getEndTime()).toDate());
                        System.out.println(DateTime.parse(owa.getAds().get(j).getEndTime()).toDate());
                    if((DateTime.parse(owa.getAds().get(i).getStartTime()).toDate()).equals(DateTime.parse(owa.getAds().get(j).getStartTime()).toDate())
                        && (DateTime.parse(owa.getAds().get(i).getEndTime()).toDate()).equals( DateTime.parse(owa.getAds().get(j).getEndTime()).toDate())){
                            OwnersAndAdsDTO q=new OwnersAndAdsDTO();
                            q.setClient(owa.getClient());
                            q.getAds().add(owa.getAds().get(i));
                            q.getAds().add(owa.getAds().get(j));
                            adss.add(q);
                            System.out.println("usao sam 4");
                        }
                    }
                }
            }
            List<OwnersAndAdsDTO> ae=new ArrayList<>();
            for(OwnersAndAdsDTO d:adss){
                if(d.getAds().size()>1){
                    ae.add(d);
                System.out.println("usao sam 5");
                }
            }
            return new ResponseEntity<>(ae, HttpStatus.OK);
    }

    @PostMapping("/reserveBundle")
    public ResponseEntity reserveBundle(@RequestBody BundleDTO bundleDTO,@RequestParam(value = "email", required = true) String email){
        RentRequest rr = new RentRequest();
        Set<Car> carsForRent= new HashSet<>();
        DateTime startD=new DateTime();
        DateTime endD=new DateTime();
        for(AdRentDTO a:bundleDTO.getAdsWithTimes()){
            Ad ad = a.getAd();
            startD = DateTime.parse(a.getStartTime());
            endD = DateTime.parse(a.getEndTime());
            carsForRent.add(a.getAd().getCar());
        }
        rr.setCarsForRent(carsForRent);
        rr.setClient(clientService.findClientByEmail(email));
        rr.setReservedFrom(startD.toDate());
        rr.setReservedTo(endD.toDate());
        rr.setRentRequestStatus(RentRequestStatus.PENDING);
        rr.setTimeCreated(LocalDateTime.now());

        Client client =clientService.findClientByEmail(email);
        if(client.isAllowReservation() == true) {
            rentRequestService.addRent(rr);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value = "/addToCart")
    public String addToCart(@RequestBody AdRentDTO adRentDTO){
        System.out.println(adRentDTO);
        Cart c=cartService.findCartByAd(adRentDTO.getAd());
        if (c == null){
            Cart ct=new Cart();
            ct.setAd(adRentDTO.getAd());
            ct.setStartTime(DateTime.parse(adRentDTO.getStartTime()).toDate());
            ct.setEndTime(DateTime.parse(adRentDTO.getEndTime()).toDate());
            cartService.addCart(ct);
        }
        else{
            return "Serial already exists";
        }
        return "";
    }

    @GetMapping(value = "/allCart")
    public ResponseEntity<List<Cart>> allCart() {
        return new ResponseEntity<>(cartService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/deleteCart")
    public ResponseEntity deleteCart(@RequestParam(value = "email", required = true) String email){
        List<Cart> carts= cartService.findAll();
        if(carts==null){
            return  new ResponseEntity<>(HttpStatus.OK);
        }else {
           cartService.deleteAll();
            return  new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
