import { Component, OnInit } from '@angular/core';
import {MatDialog, MatTableDataSource} from '@angular/material';
import {User} from '../../model/user';
import {RentRequest} from '../../model/rentRequest';
import {RentingService} from '../../services/renting.service';
import {UserService} from '../../services/user.service';
import {SearchResultDialogComponent} from '../search-result-dialog/search-result-dialog.component';
import {RateDialogComponent} from '../rate-dialog/rate-dialog.component';
import {AdViewDialogComponent} from '../ad-view-dialog/ad-view-dialog.component';
import {SendMessageDialogComponent} from '../send-message-dialog/send-message-dialog.component';
import {RateBundleComponent} from '../rate-bundle/rate-bundle.component';

@Component({
  selector: 'app-end-user-rented-cars',
  templateUrl: './end-user-rented-cars.component.html',
  styleUrls: ['./end-user-rented-cars.component.css']
})
export class EndUserRentedCarsComponent implements OnInit {

  displayedColumns: string[] = ['id', 'reservedFrom', 'reservedTo', 'cars', 'rate', 'message'];
  flag: boolean;

  users: Array<User>;
  dataSource = new MatTableDataSource<RentRequest>();

  constructor(private rentService: RentingService,
              private userService: UserService,
              public dialog: MatDialog) {
    this.dataSource = new MatTableDataSource(rentService.getRentedAds());
  }

  ngOnInit() {
  }

  async rate(request) {
    console.log(request.reservedTo);
    this.flag = await this.rentService.getFlagForRent(request.reservedTo);
    setTimeout(() => {
      if (this.flag === true) {
        this.dialog.open(RateBundleComponent, {
          width: '50%', disableClose: true, data: request.carsForRent,
        });
      }
      }, 200);
  }

  carsToString(request: RentRequest) {
    let ret = '';
    for (const r of request.carsForRent) {
      ret = r.carModel.model + ',';
    }
    ret = ret.substring(0, ret.length - 1);
    return ret;
  }

  message(request) {
    setTimeout(() => {
      this.dialog.open(SendMessageDialogComponent, {
        width: '60%', disableClose: true, data: request.carsForRent
      }); }, 200);
  }

}
