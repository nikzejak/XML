import { Injectable } from '@angular/core';
import {RentRequest} from '../model/rentRequest';
import {Router} from '@angular/router';
import {HttpClient, HttpParams} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RentServiceService {

  request: RentRequest;
  requestsForUser: Array<RentRequest> = new Array<RentRequest>();
  userRentedAds: Array<RentRequest> = new Array<RentRequest>();
  userRentedReservedAds: Array<RentRequest> = new Array<RentRequest>();
  flag: boolean;

  constructor(private router: Router, private http: HttpClient) {

  }

  public getUserRentedAds(email: string) {
    this.userRentedAds = new Array<RentRequest>();
    let params = new HttpParams();
    params = params.append('email', email);
    this.http.get(environment.url + environment.renting  + '/userRentedAds', {params}).subscribe((data: RentRequest[]) => {
        console.log(data);
        this.userRentedAds = data;
      },
      error => {
        console.log(error);
      }
    );
    console.log(this.userRentedAds);
    return this.userRentedAds;
  }

  public getRentedAds() {
    return this.userRentedAds;
  }

  public async getFlagForRent(reservedTo: string): Promise<boolean> {
    let params = new HttpParams();
    params = params.append('reservedTo', reservedTo);
    const response: any = await this.http.get(environment.url + environment.renting + '/rateCarFlag', {params}).toPromise();
    return response;
  }

  public getUserRentedReservedAds(email: string) {
    this.userRentedReservedAds = new Array<RentRequest>();
    let params = new HttpParams();
    params = params.append('email', email);
    this.http.get(environment.url + environment.renting  + '/userReservedAds', {params}).subscribe((data: RentRequest[]) => {
        console.log(data);
        this.userRentedReservedAds = data;
      },
      error => {
        console.log(error);
      }
    );
    console.log(this.userRentedReservedAds);
    return this.userRentedReservedAds;
  }

  getRentedReservedAds() {
    return this.userRentedReservedAds;
  }
}
