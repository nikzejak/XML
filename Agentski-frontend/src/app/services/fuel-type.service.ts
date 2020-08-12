import { Injectable } from '@angular/core';
import {FuelType} from '../model/fuelType';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FuelTypeService {

  listFuelTypes: Array<FuelType> = new Array<FuelType>();
  fuelType: FuelType;

  constructor(private http: HttpClient) {
    this.getAllFuelType();
  }

  public addFuelType(t: FuelType) {
    if (this.getFuelType(t.serialNumber) === null) {
      this.listFuelTypes.push(t);
    }
  }

  public getFuelType(serialNumber: string) {
    if (this.listFuelTypes.length === 0) {
      return null;
    }
    for (const u of this.listFuelTypes) {
      if (u.serialNumber === serialNumber) {
        return u;
      }
    }
    return  null;
  }

  public getAllFuelType(): Array<FuelType> {
    this.http.get(environment.url  + environment.fuelType + '/all').subscribe((data: FuelType[]) => {
        let flag = 0;
        console.log(data);
        for (const c of data) {
          flag = 0;
          this.fuelType = new FuelType(c.type, c.serialNumber);
          for (const t of this.listFuelTypes) {
            if (c.type === t.type) {
              flag = 1;
            }
          }
          if (flag === 0) {
            this.listFuelTypes.push(this.fuelType);
          }
          this.addFuelType(this.fuelType);
        }
      },
      error => {
        console.log(error);
      }
    );
    return this.listFuelTypes;
  }

  public newFuelType(fuelType) {
    return this.http.post(environment.url  + environment.fuelType  + '/addFuelType', fuelType);
  }
}
