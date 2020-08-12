import { Component, OnInit } from '@angular/core';
import {User} from '../../model/user';
import {MatDialog, MatTableDataSource} from '@angular/material';
import {RentRequest} from '../../model/rentRequest';
import {RentServiceService} from '../../services/rent-service.service';
import {UserService} from '../../services/user.service';
import {SendMessageDialogComponent} from '../send-message-dialog/send-message-dialog.component';
import {DistanceDialogComponent} from "../distance-dialog/distance-dialog.component";

@Component({
  selector: 'app-agent-reserved-cars',
  templateUrl: './agent-reserved-cars.component.html',
  styleUrls: ['./agent-reserved-cars.component.css']
})
export class AgentReservedCarsComponent implements OnInit {


  displayedColumns: string[] = ['id', 'reservedFrom', 'reservedTo', 'cars', 'message', 'allowed'];

  flag: boolean;

  users: Array<User>;
  dataSource = new MatTableDataSource<RentRequest>();

  constructor(private rentService: RentServiceService,
              private userService: UserService,
              public dialog: MatDialog,
              public dialog1: MatDialog) {
    this.dataSource = new MatTableDataSource(rentService.getRentedReservedAds());
  }

  ngOnInit() {
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
        width: '60%', disableClose: true, data: request.id
      }); }, 200);
  }

  set_distance(request) {
    setTimeout(() => {
      this.dialog.open(DistanceDialogComponent, {
        width: '60%', disableClose: true, data: request
      }); }, 200);
  }

}
