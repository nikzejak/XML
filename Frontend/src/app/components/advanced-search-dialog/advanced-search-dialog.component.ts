import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef, MatPaginator} from '@angular/material';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AdService} from '../../services/ad.service';
import {FuelTypeService} from '../../services/fuel-type.service';
import {CarTypeService} from '../../services/car-type.service';
import {TransmissionTypeService} from '../../services/transmission-type.service';
import {UserService} from '../../services/user.service';
import {Ad} from '../../model/ad';
import {Car} from '../../model/car';
import {CarBrand} from '../../model/carBrand';
import {CarType} from '../../model/carType';
import {CarModel} from '../../model/carModel';
import {TransmissionType} from '../../model/transmissionType';
import {FuelType} from '../../model/fuelType';
import {Client} from '../../model/client';
import {CarStatus} from '../../model/carStatus';
import {AdvancedSearch} from '../../model/advancedSearch';
import {AddPicturesDialogComponent} from '../add-pictures-dialog/add-pictures-dialog.component';
import {SearchResultDialogComponent} from '../search-result-dialog/search-result-dialog.component';
import {AdsWithTimes} from '../../model/adsWithTimes';

@Component({
  selector: 'app-advanced-search-dialog',
  templateUrl: './advanced-search-dialog.component.html',
  styleUrls: ['./advanced-search-dialog.component.css']
})
export class AdvancedSearchDialogComponent implements OnInit {
  addAdForm: FormGroup;
  submitted = false;
  ad: Ad;
  car: Car;
  carBrand: CarBrand;
  carType: CarType;
  carModel: CarModel;
  transmissionType: TransmissionType;
  fuelType: FuelType;
  client: Client;
  email: string;
  fuelTypes: Array<FuelType>;
  carTypes: Array<CarType>;
  transTypes: Array<TransmissionType>;
  adSearch: AdvancedSearch;
  myResponse: Ad[];
  adsWithTimes: AdsWithTimes;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  ads: Array<Ad> = new Array<Ad>();
  constructor(public dialog: MatDialog,
              private formBuilder: FormBuilder,
              private router: Router,
              private adService: AdService,
              private fuelTypeService: FuelTypeService,
              private carTypeService: CarTypeService,
              private transmissionTypeService: TransmissionTypeService,
              private userService: UserService,
              public dialogRef: MatDialogRef<AdvancedSearchDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
    this.fuelTypes = fuelTypeService.getAllFuelType();
    this.carTypes = carTypeService.getAllCarType();
    this.transTypes = transmissionTypeService.getAllTransmissionType();
    this.email = this.userService.getLoggedUser().email;
    this.adsWithTimes = new AdsWithTimes();
    console.log('Email ispod');
    console.log(this.data);
    console.log(this.email);
  }

  ngOnInit() {
    this.addAdForm = this.formBuilder.group({
      carBrand: new FormControl('' ),
      fuelType: new FormControl('', ),
      carType: new FormControl('',),
      transmissionType: new FormControl('', ),
      mileage: new FormControl('', ),
      distanceAllowed: new FormControl('', ),
      cdw: new FormControl('', ),
      childSeats: new FormControl('', ),
      price: new FormControl('', ),
      price2: new FormControl('', ),
      carModel: new FormControl('', ),
    });
  }
  get f() {
    return this.addAdForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    // Stop here if form is invalid
    if (this.addAdForm.invalid) {
      return;
    }

    this.carBrand = new CarBrand(this.f.carBrand.value);
    this.carModel = new CarModel(this.f.carModel.value);
    this.fuelType = new FuelType(this.f.fuelType.value);
    this.transmissionType = new TransmissionType(this.f.transmissionType.value);
    this.carType = new CarType(this.f.carType.value);
    console.log(this.f.carType.value);
    console.log(this.carType.type);
    let c = false;
    if (this.f.cdw.value === 'Yes') {
      c = true;
    } else {
      c = false;
    }
    this.adSearch = new AdvancedSearch(this.carBrand.brand, this.carModel.model, this.fuelType.type, this.transmissionType.type,
      this.carType.type, this.f.price.value, this.f.price2.value, c, this.f.childSeats.value, this.f.mileage.value,
      this.f.distanceAllowed.value);
    this.adSearch.ads = this.data.ads;
    console.log(this.adSearch);
    this.filter();
  }

  private filter() {
    this.myResponse = this.adService.getAllAdvanced(this.adSearch);
    this.adsWithTimes.ads = this.myResponse;
    this.adsWithTimes.startTime = this.data.startTime;
    this.adsWithTimes.endTime = this.data.endTime;
    console.log(this.data.startTime);
    setTimeout(() => {
      this.dialog.open(SearchResultDialogComponent, {
        width: '60%', disableClose: true, data: this.adsWithTimes,
      }); }, 200);
    this.dialogRef.close();
  }

  close() {
    this.dialogRef.close();
  }
}
