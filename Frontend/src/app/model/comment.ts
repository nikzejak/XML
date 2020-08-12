import {User} from './user';
import {Ad} from './ad';
import {Car} from './car';

export class Comment {
  id: number;
  commenter: User;
  comment: string;
  approved: boolean;
  carRating: number;
  ad: Ad;
  cars: Array<Car> = new Array<Car>();

/*
  constructor(id?: number, commenter?: User, comment?: string, approved?: boolean, carRating?: number, ad?: Ad) {
    this.id = id;
    this.commenter = commenter;
    this.comment = comment;
    this.approved = approved;
    this.carRating = carRating;
    this.ad = ad;
  }*/


  constructor() {
  }
}
