import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {AdService} from '../../services/ad.service';
import {Ad} from '../../model/ad';
import {RentRequest} from '../../model/rentRequest';
import {RentingService} from '../../services/renting.service';
import {MessageService} from '../../services/message.service';
import {User} from '../../model/user';
import {PriceList} from '../../model/priceList';
import {PriceListService} from '../../services/price-list.service';
import {AdWithTimes} from '../../model/adWithTimes';

@Component({
  selector: 'app-end-user-home-page',
  templateUrl: './end-user-home-page.component.html',
  styleUrls: ['./end-user-home-page.component.css']
})
export class EndUserHomePageComponent implements OnInit {

  tmp: Array<Ad>;
  tmp1: Array<RentRequest>;
  tmp2: Array<RentRequest>;
  tmp3: Array<User>;
  tmp4: Array<PriceList>;
  adWithTimes: Array<AdWithTimes> = new Array<AdWithTimes>();
  constructor(private userService: UserService,
              private adService: AdService,
              private rentingService: RentingService,
              private messageService: MessageService,
              private priceListService: PriceListService,) {
      this.tmp = adService.getAllClientAds(userService.getLoggedUser().email);
      this.tmp1 = rentingService.getRentRequestsForUser(userService.getLoggedUser().email);
      this.tmp2 = rentingService.getUserRentedAds(userService.getLoggedUser().email);
      this.tmp3 = messageService.getReceivers(userService.getLoggedUser());
      this.tmp4 = priceListService.getAgentPricelists(userService.getLoggedUser().email);
      this.adWithTimes = rentingService.getAllCart();
  }

  ngOnInit() {
  }

}
