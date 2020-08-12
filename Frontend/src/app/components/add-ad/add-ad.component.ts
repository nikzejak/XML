import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Ad} from '../../model/Ad';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {Router} from '@angular/router';
import {AdService} from '../../services/ad.service';
import {Car} from '../../model/car';
import {CarBrand} from '../../model/carBrand';
import {CarType} from '../../model/carType';
import {FuelType} from '../../model/fuelType';
import {TransmissionType} from '../../model/transmissionType';
import {Client} from '../../model/client';
import {CarModel} from '../../model/carModel';
import {AdViewDialogComponent} from '../ad-view-dialog/ad-view-dialog.component';
import {FuelTypeService} from '../../services/fuel-type.service';
import {CarStatus} from '../../model/carStatus';
import {CarTypeService} from '../../services/car-type.service';
import {TransmissionTypeService} from '../../services/transmission-type.service';
import {UserService} from '../../services/user.service';
import {AddPicturesDialogComponent} from '../add-pictures-dialog/add-pictures-dialog.component';
import {PriceList} from '../../model/priceList';
import {PriceListService} from '../../services/price-list.service';
import {PricelistViewDialogComponent} from '../pricelist-view-dialog/pricelist-view-dialog.component';



interface Cars {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-add-ad',
  templateUrl: './add-ad.component.html',
  styleUrls: ['./add-ad.component.css']
})
export class AddAdComponent implements OnInit {
  addAdForm: FormGroup;
  MakeGroup: FormGroup;
  submitted = false;
  selectedCar: string;
  displayedColumns: string[] = ['title', 'profilePicture', 'description', 'place'];
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
  priceLists: Array<PriceList>;
  price: PriceList = new PriceList();

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  ads: Array<Ad> = new Array<Ad>();
  listCarBrand: Array<CarBrand> =  new Array<CarBrand>();
  constructor(public dialog: MatDialog,
              public dialog1: MatDialog,
              private formBuilder: FormBuilder,
              private router: Router,
              private adService: AdService,
              private fuelTypeService: FuelTypeService,
              private carTypeService: CarTypeService,
              private transmissionTypeService: TransmissionTypeService,
              private userService: UserService,
              private priceListService: PriceListService) {

   // this.ad = this.adService.getAllAds();//this.all();
    this.fuelTypes = fuelTypeService.getAllFuelType();
    this.carTypes = carTypeService.getAllCarType();
    this.transTypes = transmissionTypeService.getAllTransmissionType();
    this.email = this.userService.getLoggedUser().email;
    this.priceLists = this.priceListService.getPricelistForAgent();

  }

  ngOnInit() {
    this.addAdForm = this.formBuilder.group({

      title: new FormControl('', [Validators.required]),
      startOfAd: new FormControl('', [Validators.required]),
      endOfAd: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      carBrand: new FormControl('' ),
      fuelType: new FormControl('', [Validators.required]),
      carType: new FormControl('', [Validators.required]),
      transmissionType: new FormControl('', [Validators.required]),
      mileage: new FormControl('', [Validators.required]),
      distanceAllowed: new FormControl('', [Validators.required]),
      cdw: new FormControl('', [Validators.required]),
      childSeats: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      place: new FormControl('', [Validators.required]),
      carModel: new FormControl('', [Validators.required]),
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

    this.car = new Car();
    this.car.carBrand = this.carBrand;
    this.car.carModel = this.carModel;
    this.price = this.priceListService.findPricelistById(this.f.price.value);
    this.car.carType = this.carType;
    this.car.fuelType = this.fuelType;
    this.car.transmissionType = this.transmissionType;
    this.car.discount = 0;
    this.car.mileage = this.f.mileage.value;
    this.car.averageRating = 0;
    this.car.carStatus = CarStatus.NOT_RENTED;
    this.car.distanceAllowed = this.f.distanceAllowed.value;
    if (this.f.cdw.value === 'Yes') {
      this.car.collisionDemageWaiver = true;
    } else {
      this.car.collisionDemageWaiver = false;
    }

    this.car.childSeats = this.f.childSeats.value;
    this.ad = new Ad(
      this.car,
      '0',
      this.f.title.value,
      this.f.startOfAd.value,
      this.f.endOfAd.value,
      this.f.description.value,
      true,
      this.f.place.value,
      this.client
    );

    console.log(this.ad);
    this.createAd();
  }

  private createAd() {
    console.log('usao u create');
    this.adService.newAd(this.ad, this.email, this.f.price.value.toString()).subscribe(
      data => {
        this.adService.addAd(this.ad);
        setTimeout(() => {
          this.dialog.open(AddPicturesDialogComponent, {
            width: '60%', disableClose: true, data: this.ad
          }); }, 200);
      },
      error => {
        alert('Client already has 3 ads');
        console.log(error);
      }
    );
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
