import { Component, OnInit } from '@angular/core';
import {User} from '../../model/user';
import {MatDialog, MatTableDataSource} from '@angular/material';
import {RentRequest} from '../../model/rentRequest';
import {UserService} from '../../services/user.service';
import {SendMessageDialogComponent} from '../send-message-dialog/send-message-dialog.component';
import {RentServiceService} from '../../services/rent-service.service';
import {RateDialogComponentComponent} from '../rate-dialog-component/rate-dialog-component.component';


@Component({
  selector: 'app-agent-rented-cars',
  templateUrl: './agent-rented-cars.component.html',
  styleUrls: ['./agent-rented-cars.component.css']
})
export class AgentRentedCarsComponent implements OnInit {


  displayedColumns: string[] = ['id', 'reservedFrom', 'reservedTo', 'cars', 'rate', 'message'];

  flag: boolean;

  users: Array<User>;
  dataSource = new MatTableDataSource<RentRequest>();

  constructor(private rentService: RentServiceService,
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
        this.dialog.open(RateDialogComponentComponent, {
          width: '50%', disableClose: true, data: request,
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


  // message(request) {
  //   setTimeout(() => {
  //     this.dialog.open(SendMessageDialogComponent, {
  //       width: '60%', disableClose: true, data: request.carsForRent
  //     }); }, 200);
  // }


  carsToString1(request: RentRequest) {
    let ret = '';
    for (const r of request.carsForRent) {
      ret = r.carBrand.brand + ',';
    }
    ret = ret.substring(0, ret.length - 1);
    return ret;
  }


}
