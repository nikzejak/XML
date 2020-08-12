import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpParams} from '@angular/common/http';
import {PriceList} from '../model/priceList';


@Injectable({
  providedIn: 'root'
})
export class PriceListService {

  agentPriceLists: Array<PriceList> = new Array<PriceList>();

  constructor(private http: HttpClient) { }

  public newPriceList(priceList, email) {
    let params = new HttpParams();
    params = params.append('email', email);
    return this.http.post(environment.url + environment.priceList + '/addPriceList', priceList, {params});
  }

  public getAgentPricelists(email): Array<PriceList> {
    this.agentPriceLists = new Array<PriceList>();
    let params = new HttpParams();
    params = params.append('email', email);
    this.http.get(environment.url + environment.priceList  + '/agentPricelists', {params}).subscribe((data: PriceList[]) => {
        console.log(data);
        this.agentPriceLists = data;
      },
      error => {
        console.log(error);
      }
    );
    return this.agentPriceLists;
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
}
