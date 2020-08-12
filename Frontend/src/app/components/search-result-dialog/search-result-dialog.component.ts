import {Component, Inject, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {Ad} from '../../model/ad';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material';
import {AdSearchModel} from '../../model/adSearchModel';
import {AdService} from '../../services/ad.service';
import { AdViewDialogComponent } from '../ad-view-dialog/ad-view-dialog.component';
import {AdWithTimes} from '../../model/adWithTimes';
import {AdsWithTimes} from '../../model/adsWithTimes';
import {AdvancedSearchDialogComponent} from '../advanced-search-dialog/advanced-search-dialog.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-search-result-dialog',
  templateUrl: './search-result-dialog.component.html',
  styleUrls: ['./search-result-dialog.component.css']
})
export class SearchResultDialogComponent implements OnInit {

  displayedColumns: string[] = ['title', 'price', 'place', 'details'];
  dataSource: MatTableDataSource<Ad>;
  myResponse: Ad[];
  adWithTimes: AdWithTimes;
  adsWithTimes: AdsWithTimes;
  private submitted = false;
  constructor(public dialogRef: MatDialogRef<SearchResultDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              public adService: AdService,
              public dialog: MatDialog,
              private router: Router) {
    this.adWithTimes = new AdWithTimes();
    this.adsWithTimes = new AdsWithTimes();
  }

  ngOnInit() {
    this.adsWithTimes = this.data;
    this.myResponse = this.adsWithTimes.ads;
    this.dataSource = new MatTableDataSource<Ad>(this.myResponse);
    this.adWithTimes.startTime = this.adsWithTimes.startTime;
    this.adWithTimes.endTime = this.adsWithTimes.endTime;
    console.log(this.adsWithTimes.startTime);
  }

  close() {
    this.myResponse.splice(0, this.myResponse.length);
    this.router.navigate(['endUser/home']);
    this.dialogRef.close();
  }

  detail(ad: Ad) {
    console.log('Ad ispod')
    console.log(ad);
    this.adWithTimes.ad = ad;

    setTimeout(() => {
  this.dialog.open(AdViewDialogComponent, {
    width: '60%', disableClose: true, data: this.adWithTimes
  }); }, 200);
  }

  filter() {
    setTimeout(() => {
      this.dialog.open(AdvancedSearchDialogComponent, {
        width: '40%', disableClose: true, data: this.adsWithTimes
      }); }, 200);
    this.dialogRef.close();
  }

}
