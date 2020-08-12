import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {AdViewDialogComponent} from '../ad-view-dialog/ad-view-dialog.component';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef, MatPaginator} from '@angular/material';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AdService} from '../../services/ad.service';
import {AdsWithTimes} from '../../model/adsWithTimes';
import {AdSearchModel} from '../../model/adSearchModel';
import {SearchResultDialogComponent} from '../search-result-dialog/search-result-dialog.component';
import {AdWithTimes} from '../../model/adWithTimes';

@Component({
  selector: 'app-rent-dialog',
  templateUrl: './rent-dialog.component.html',
  styleUrls: ['./rent-dialog.component.css']
})
export class RentDialogComponent implements OnInit {

  private submitted = false;
  model = new AdSearchModel('', '', '');
  SearchForm: FormGroup;
  a: AdWithTimes;
  constructor(private formBuilder: FormBuilder, private adService: AdService,  public dialog: MatDialog,
              public dialogRef: MatDialogRef<RentDialogComponent>, @Inject(MAT_DIALOG_DATA) public dataAd: any) {
    this.a = new AdWithTimes();
  }

  ngOnInit() {
    this.SearchForm = this.formBuilder.group({
      startDate: [''],
      endDate: ['']
    });
  }
  get f() {
    return this.SearchForm.controls;
  }

  close() {
    this.dialogRef.close();
  }

  onSubmit() {
    this.submitted = true;
    this.a.startTime = this.f.startDate.value;
    this.a.endTime = this.f.endDate.value;
    this.a.ad = this.dataAd;
    this.adService.reserveMyAd(this.a).subscribe(
      res => {
        alert('Reserved');
        this.dialogRef.close();
      },
      error => {
        alert('Error');
      }
    );



  }


}
