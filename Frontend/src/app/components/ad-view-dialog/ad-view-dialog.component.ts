import {Component, HostListener, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef, MatTableDataSource} from '@angular/material';
import {AdService} from '../../services/ad.service';
import {Ad} from '../../model/ad';
import {environment} from '../../../environments/environment';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Route, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {AdWithTimes} from '../../model/adWithTimes';
import {UserService} from '../../services/user.service';
import {PriceList} from '../../model/priceList';
import {PriceListService} from '../../services/price-list.service';
import {PricelistViewDialogComponent} from '../pricelist-view-dialog/pricelist-view-dialog.component';
import {EndUserHomePageComponent} from '../end-user-home-page/end-user-home-page.component';
import {RentingService} from '../../services/renting.service';
@Component({
  selector: 'app-ad-view-dialog',
  templateUrl: './ad-view-dialog.component.html',
  styleUrls: ['./ad-view-dialog.component.css']
})
export class AdViewDialogComponent implements OnInit {
  images: Array<string> = new Array<string>();
  image: string;
  i = 0;
  data: Ad;
  submitted = false;
  adViewForm: FormGroup;
  adWithTimes: AdWithTimes;
  priceList: PriceList;

  // tslint:disable-next-line:max-line-length
  constructor(private formBuilder: FormBuilder, private router: Router, private adService: AdService,
              public dialogRef: MatDialogRef<AdViewDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public datas: any,
              public dialog: MatDialog, private http: HttpClient,
              private userService: UserService,
              private priceListService: PriceListService,
              public dialog1: MatDialog,
              private rentingService: RentingService) {

    this.adWithTimes = this.datas;
    this.click();
    this.data = this.adWithTimes.ad;
    this.priceList = this.priceListService.findPriceListByAdID(this.data.id);
    console.log(this.priceList);
    this.image = this.images[0];

  }

  ngOnInit() {
    this.adViewForm = this.formBuilder.group({
      title: new FormControl(this.data.title),
      description: new FormControl(this.data.description),
      carBrand: new FormControl(this.data.car.carBrand.brand),
      carModel: new FormControl(this.data.car.carModel.model),
      carType: new FormControl(this.data.car.carType.type),
      fuelType: new FormControl(this.data.car.fuelType.type),
      transmissionType: new FormControl(this.data.car.transmissionType.type),
      distanceAllowed: new FormControl(this.data.car.distanceAllowed),
      mileage: new FormControl(this.data.car.mileage),
      place: new FormControl(this.data.place),
      price: new FormControl(this.priceList.id),
      carStatus: new FormControl(this.data.car.carStatus),
      childSeats: new FormControl(this.data.car.childSeats)
    });

  }

  get f() {
    return this.adViewForm.controls;
  }


  close() {
    this.dialogRef.close();
  }

  nextImage() {
    if (this.i < this.images.length - 1) {
      this.i = this.i + 1;
    }

    this.image = this.images[this.i];

  }

  previous_image() {
    if (this.i > 0) {
      this.i = this.i - 1;
    }
    this.image = this.images[this.i];
  }

  click() {
    this.http.post(environment.gateway + environment.ad + '/getPic', this.adWithTimes.ad.id).subscribe((data: string[]) => {
      console.log(data);
      this.images = data;
    });

 }

 onSubmit() {
  //  this.userService.addToList(this.adWithTimes);
   this.rentingService.newCartAd(this.adWithTimes).subscribe(
     data => {
       alert('Uspesno dodato u cart');
       this.dialogRef.close();
     },
     error => {
       alert('Error adding car brand');
       console.log(error);
     }
   );
 }

  view() {
      this.dialog1.open(PricelistViewDialogComponent, {
        width: '40%', disableClose: true, data: this.priceList
      });
    }
}




