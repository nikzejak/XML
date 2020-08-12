import { Component, OnInit } from '@angular/core';
import {TransmissionType} from '../../model/transmissionType';
import {FuelType} from '../../model/fuelType';
import {CarType} from '../../model/carType';
import {CarTypeService} from '../../services/car-type.service';
import {FuelTypeService} from '../../services/fuel-type.service';
import {TransmissionTypeService} from '../../services/transmission-type.service';
import {Ad} from '../../model/ad';
import {UserService} from '../../services/user.service';
import {AdService} from '../../services/ad.service';
import {RentRequest} from '../../model/rentRequest';
import {RentServiceService} from '../../services/rent-service.service';
import {RateServiceService} from '../../services/rate-service.service';
import {MessageService} from '../../services/message.service';
import {Message} from '../../model/message';
import {User} from '../../model/user';
import {PriceList} from "../../model/priceList";
import {PriceListService} from "../../services/price-list.service";

@Component({
  selector: 'app-agent-home',
  templateUrl: './agent-home.component.html',
  styleUrls: ['./agent-home.component.css']
})
export class AgentHomeComponent implements OnInit {

  t: Array<CarType>;
  f: Array<FuelType>;
  trans: Array<TransmissionType>;
  tmp: Array<Ad>;
  tmp2: Array<RentRequest>;
  tmp3: Array<RentRequest>;
  adm: Array<Comment>;
  m: Array<User>;
  pl: Array<PriceList>;

  constructor(private carTypeService: CarTypeService,
              private fuelTypeService: FuelTypeService,
              private transmissionTypeService: TransmissionTypeService,
              private userService: UserService,
              private adService: AdService,
              private rentingService: RentServiceService,
              private rateService: RateServiceService,
              private messageService: MessageService,
              private pricelistService: PriceListService) {
    this.t = this.carTypeService.getAllCarType();
    this.f = this.fuelTypeService.getAllFuelType();
    this.trans = this.transmissionTypeService.getAllTransmissionType();
    this.tmp = adService.getAllClientAds(userService.getLoggedUser().email);
    this.tmp2 = this.rentingService.getUserRentedAds(userService.getLoggedUser().email);
    this.adm = this.rateService.getCommentForOperation();
    this.tmp3 = this.rentingService.getUserRentedReservedAds(this.userService.getLoggedUser().email);
  //  this.m = this.messageService.getReceivers(this.userService.getLoggedUser());
    this.pl = this.pricelistService.getAgentPricelists(this.userService.getLoggedUser().email);
  }

  ngOnInit() {
  }

}
