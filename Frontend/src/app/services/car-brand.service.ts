import { Injectable } from '@angular/core';
import {CarType} from "../model/carType";
import {CarBrand} from "../model/carBrand";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Car} from "../model/car";
import {User} from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class CarBrandService {

  listCarBrands: Array<CarBrand> = new Array<CarBrand>();
  carBrand: CarBrand;
  endCarBrandsForOperations: Array<CarBrand> = new Array<CarBrand>();
  endCarBrand: CarBrand;

  constructor(private http: HttpClient, private carBrandService: CarBrandService) {
   // this.getAllCarBrand();
    this.listCarBrands = this.getCarBrandsForOperations();
  }

  public addCarBrand(t: CarBrand){
    if(this.getCarBrand(t.brand) === null){
      this.listCarBrands.push(t);
    }
  }
  public getCarBrand(brand: string) {
    if (this.listCarBrands.length === 0) {
      return null;
    }
    for (const u of this.listCarBrands) {
      if (u.brand === brand) {
        return u;
      }
    }
    return  null;
  }

  public getAllCarBrand(): Array<CarBrand> {
    this.listCarBrands = new Array<CarBrand>();
    this.http.get(environment.gateway + environment.admin + '/carBrand/all').subscribe((data: CarBrand[]) => {
        let flag = 0;
        for (const c of data) {
          flag = 0;
          this.carBrand = new CarBrand(c.brand);
          for(const t of this.listCarBrands){
            if (c.brand === t.brand){
              flag = 1;
            }
          }
          if(flag === 0) {
            this.listCarBrands.push(this.carBrand);
          }
        }
      },
      error => {
        console.log(error);
      }
    );
    return this.listCarBrands;
  }

  public newCarBrand(carBrand){
    return this.http.post(environment.gateway + environment.admin + '/addCarBrand', carBrand);
  }

  //ovo si dodao nakon cele tabele
  public AccountOperation(operation: string, brand: string) {
    let params = new HttpParams();
    params = params.append('operation', operation);
    params = params.append('brand', brand);

    return this.http.post(environment.gateway + environment.admin + '/brandOperation', params);

  }

  public getCarBrandsForOperations() {
    return this.listCarBrands;
  }

}
