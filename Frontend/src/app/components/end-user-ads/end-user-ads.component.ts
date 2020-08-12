import { Component, OnInit } from '@angular/core';
import {MatDialog, MatTableDataSource} from '@angular/material';
import {Ad} from '../../model/ad';
import {AdService} from '../../services/ad.service';
import {Router} from '@angular/router';
import {SearchResultDialogComponent} from '../search-result-dialog/search-result-dialog.component';
import {RentDialogComponent} from '../rent-dialog/rent-dialog.component';

@Component({
  selector: 'app-end-user-ads',
  templateUrl: './end-user-ads.component.html',
  styleUrls: ['./end-user-ads.component.css']
})
export class EndUserAdsComponent implements OnInit {

  displayedColumns: string[] = ['title', 'carModel', 'carBrand', 'place', 'status', 'change'];
  dataSource = new MatTableDataSource<Ad>();
  constructor(private adService: AdService,
              private router: Router, public dialog: MatDialog) {
    this.dataSource = new MatTableDataSource(adService.getClientAds());
  }

  ngOnInit() {
  }

  change_status(ad) {
    setTimeout(() => {
      this.dialog.open(RentDialogComponent, {
        width: '50%', disableClose: true, data: ad,
      }); }, 200);
  }

}
