import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Car} from '../../model/car';
import {MatDialog, MatPaginator} from '@angular/material';
import {Ad} from '../../model/ad';
import {AdService} from '../../services/ad.service';
import {MatTableDataSource} from '@angular/material/table';
import {__await} from 'tslib';
import {isNull, isUndefined} from 'util';
import {SearchResultDialogComponent} from '../search-result-dialog/search-result-dialog.component';
import {AdSearchModel} from '../../model/adSearchModel';
import {AdWithTimes} from '../../model/adWithTimes';
import {AdsWithTimes} from '../../model/adsWithTimes';

@Component({
  selector: 'app-car-search',
  templateUrl: './car-search.component.html',
  styleUrls: ['./car-search.component.css']
})
export class CarSearchComponent implements OnInit {
  displayedColumns: string[] = ['title', 'price', 'place'];
  dataSource: MatTableDataSource<Ad>;
  myResponse: Ad[];
  filter: Ad[];
  private submitted = false;
  adsWithTimes: AdsWithTimes;
  model = new AdSearchModel('', '', '');

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  SearchForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private adService: AdService,  public dialog: MatDialog) {
    this.adsWithTimes = new AdsWithTimes();
  }
  ngOnInit() {
    this.SearchForm = this.formBuilder.group({
      startDate: [''],
      endDate: [''],
      place: ['']
    });
  }

    onSubmit() {
  }

  get f() {
    return this.SearchForm.controls;
  }
  openDialog() {
      this.submitted = true;
      this.model.startDate = this.f.startDate.value;
      this.model.endDate = this.f.endDate.value;
      this.model.place = this.f.place.value;
      this.myResponse = this.adService.getAllFilter(this.model);
      this.adsWithTimes.ads = this.myResponse;
      this.adsWithTimes.startTime = this.model.startDate;
      this.adsWithTimes.endTime = this.model.endDate;
      console.log('ISPOD TREBA');
      console.log(this.adsWithTimes);
      setTimeout(() => {
      this.dialog.open(SearchResultDialogComponent, {
        width: '50%', disableClose: true, data: this.adsWithTimes,
      }); }, 200);

    }

}
