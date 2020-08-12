import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {User} from '../../model/user';
import {CarBrand} from '../../model/carBrand';
import {CarBrandService} from '../../services/car-brand.service';
import {CarModel} from '../../model/carModel';
import {CarModelService} from '../../services/car-model.service';
import {CarType} from '../../model/carType';
import {FuelType} from '../../model/fuelType';
import {TransmissionType} from '../../model/transmissionType';
import {CarTypeService} from '../../services/car-type.service';
import {FuelTypeService} from '../../services/fuel-type.service';
import {TransmissionTypeService} from '../../services/transmission-type.service';
import {AdminService} from '../../services/admin.service';
import {Comment} from '../../model/comment';
import {Client} from '../../model/client';

@Component({
  selector: 'app-administrator-home-page',
  templateUrl: './administrator-home-page.component.html',
  styleUrls: ['./administrator-home-page.component.css']
})
export class AdministratorHomePageComponent implements OnInit {
  adm: Array<Comment>;
  tmp: Array<User>;
  b: Array<CarBrand>;
  m: Array<CarModel>;
  t: Array<CarType>;
  f: Array<FuelType>;
  trans: Array<TransmissionType>;
  tmp2: Array<Client>;

  constructor(private userService: UserService, private carBrandService: CarBrandService, private carTypeSerivice: CarTypeService, private fuelTypeService: FuelTypeService,
              private transmissionTypeService: TransmissionTypeService,
              private carModelService: CarModelService,
              private adminService: AdminService) {
    this.tmp = this.userService.getEndUsersForOperations();
    this.adm = this.adminService.getCommentForOperation();
    this.b = this.carBrandService.getAllCarBrand();
    this.m = this.carModelService.getAllCarModel();
    this.t = this.carTypeSerivice.getAllCarType();
    this.f = this.fuelTypeService.getAllFuelType();
    this.trans = this.transmissionTypeService.getAllTransmissionType();
    this.tmp2 = this.adminService.getClientsForPermissions();
  }

  ngOnInit() {
  }

}
