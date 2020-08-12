import {Ad} from './ad';
import {Client} from './client';

export class PriceList {
  id: number;
  realPrice: number;
  priceForMileage: number;
  priceForCollisionDamageWavier: number;
  discountAfterDays: number;
  ads: Array<Ad>;
  client: Client;

  constructor() {}
}
