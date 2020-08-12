import {Car} from './car';
import {RentRequestStatus} from './rentRequestStatus';

export class RentRequest {
  id: number;
  reservedFrom: string;
  reservedTo: string;
  rentRequestStatus: RentRequestStatus;
  carsForRent: Array<Car> = new Array<Car>();

  constructor() {
  }

}
