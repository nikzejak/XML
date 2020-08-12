import {Car} from './car';
import {Client} from './client';
import {Ad} from './ad';

export class AdvancedSearch{
  carBrand: string;
  carModel: string;
  fuelType: string;
  transmissionType: string;
  carType: string;
  price: number;
  price2: number;
  cdw: boolean;
  childSeat: number;
  mileage: number;
  distanceAllowed: number;
  ads: Ad[];

  constructor(carBrand: string, carModel: string, fuelType: string, transmissionType: string, carType: string, price: number,
              price2: number, cdw: boolean, childSeat: number, mileage: number, distanceAllowed: number) {
    this.carBrand = carBrand;
    this.carModel = carModel;
    this.fuelType = fuelType;
    this.transmissionType = transmissionType;
    this.carType = carType;
    this.price = price;
    this.price2 = price2;
    this.cdw = cdw;
    this.childSeat = childSeat;
    this.mileage = mileage;
    this.distanceAllowed = distanceAllowed;
  }
}
