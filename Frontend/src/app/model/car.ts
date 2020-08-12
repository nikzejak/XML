import {CarBrand} from './carBrand';
import {FuelType} from './fuelType';
import {TransmissionType} from './transmissionType';
import {CarType} from './carType';
import {CarModel} from './carModel';
import {CarStatus} from './carStatus';

export class Car {
  carBrand: CarBrand;
  carType: CarType;
  fuelType: FuelType;
  transmissionType: TransmissionType;
  carModel: CarModel;
  discount: number;
  mileage: number;
  carStatus: CarStatus;
  distanceAllowed: number;
  collisionDemageWaiver: boolean;
  childSeats: number;
  averageRating: number;

  constructor() {
  }


}

