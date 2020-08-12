import { Injectable } from '@angular/core';
import {PriceList} from '../model/priceList';
import {HttpClient, HttpParams} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PriceListService {
  agentPriceLists: Array<PriceList> = new Array<PriceList>();
  priceListForDialog: PriceList;
  constructor(private http: HttpClient) { }

  public newPriceList(priceList, email) {
    let params = new HttpParams();
    params = params.append('email', email);
    return this.http.post(environment.gateway + environment.ad + '/addPriceList', priceList, {params});
  }

  public getAgentPricelists(email): Array<PriceList> {
    this.agentPriceLists = new Array<PriceList>();
    let params = new HttpParams();
    params = params.append('email', email);
    this.http.get(environment.gateway + environment.ad  + '/userPriceLists', {params}).subscribe((data: PriceList[]) => {
        console.log(data);
        this.agentPriceLists = data;
      },
      error => {
        console.log(error);
      }
    );
    return this.agentPriceLists;
  }

  // Ad id parametar
  public async getPriceListForDialog(id): Promise<PriceList> {
    let params = new HttpParams();
    params = params.append('id', id);
    const response: any = await this.http.get(environment.gateway + environment.ad  + '/priceListByAdId', {params}).toPromise();
    return response;
  }



  public getPricelistForAgent() {
    return this.agentPriceLists;
  }

  public findPricelistById(id) {
    for (const c of this.agentPriceLists) {
      if (c.id.toString() === id) {
        return c;
      }
    }
    return null;
  }

  public findPriceListByAdID(id) {
    for (const c of this.agentPriceLists) {
     for (const c1 of c.ads) {
       if (c1.id === id) {
         return c;
       }
     }
    }
    return null;
  }
}
