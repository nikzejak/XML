import {Ad} from './ad';
import {Role} from './role';

export class Client {
  id: number;
  email: string;
  firstName: string;
  lastName: string;
  password: string;
  jmbg: string;
  phoneNumber: string;
  personalID: string;
  pib: string;
  address: string;
  ads: Array<Ad> = new Array<Ad>();
  adCounter: number;
  role: Role;
  allowReservation: boolean;
  reservationCanceledCounter: number;

  constructor() {}
}
