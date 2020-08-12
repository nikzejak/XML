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
import {PricelistViewDialogComponent} from '../pricelist-view-dialog/pricelist-view-dialog.component';
import {PriceList} from '../../model/priceList';
import {PriceListService} from '../../services/price-list.service';
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
  priceLists: Array<PriceList>;
  price: PriceList = new PriceList();

  // tslint:disable-next-line:max-line-length
  constructor(private formBuilder: FormBuilder, private router: Router, private adService: AdService, public dialogRef: MatDialogRef<AdViewDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public datas: any,
              public dialog: MatDialog, private http: HttpClient,
              public dialog1: MatDialog,
              private userService: UserService,
              private priceListService: PriceListService) {

    this.adWithTimes = this.datas;
    this.click();
    this.data = this.adWithTimes.ad;
    this.priceLists = this.priceListService.getPricelistForAgent();

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
      // price: new FormControl(this.data.car.price),
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
    this.http.post(environment.url + environment.ad + '/getPic', this.adWithTimes.ad.id).subscribe((data: string[]) => {
      console.log(data);
      this.images = data;
    });

 }

 onSubmit() {
    this.userService.addToList(this.adWithTimes);
 }

  view() {
    this.price = this.priceListService.findPricelistById(this.f.price.value);
    console.log(this.price);
    if (this.price !== null) {
      this.dialog1.open(PricelistViewDialogComponent, {
        width: '40%', disableClose: true, data: this.price
      });
    }
  }

}




