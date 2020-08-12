import { Injectable } from '@angular/core';
import {CarType} from '../model/carType';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CarTypeService {

  listCarTypes: Array<CarType> = new Array<CarType>();
  carType: CarType;

  constructor(private http: HttpClient) {
    this.getAllCarType();
  }

  public addCarType(t: CarType) {
    if (this.getCarType(t.type) === null) {
      this.listCarTypes.push(t);
    }
  }

  public getCarType(type: string) {
    if (this.listCarTypes.length === 0) {
      return null;
    }
    for (const u of this.listCarTypes) {
      if (u.type === type) {
        return u;
      }
    }
    return  null;
  }

  public getAllCarType(): Array<CarType> {
    this.http.get(environment.url + environment.carType + '/all').subscribe((data: CarType[]) => {
        let flag = 0;
        for (const c of data) {
          flag = 0;
          this.carType = new CarType(c.type);
          for (const t of this.listCarTypes) {
            if (c.type === t.type) {
              flag = 1;
            }
          }
          if (flag === 0) {
            this.listCarTypes.push(this.carType);
          }
        }
      },
      error => {
        console.log(error);
      }
    );
    return this.listCarTypes;
  }

  public newCarType(carType) {
    return this.http.post(environment.url + environment.carType + '/addCarType', carType);
  }
}
