import { Injectable } from '@angular/core';
import {RentRequest} from '../model/rentRequest';
import {Router} from '@angular/router';
import {HttpClient, HttpParams} from '@angular/common/http';
import {User} from '../model/user';
import {environment} from '../../environments/environment';
import {CarBrand} from '../model/carBrand';
import {AdWithTimes} from '../model/adWithTimes';
import {UserService} from './user.service';
import {BundleModel} from '../model/bundleModel';
import {CommentBundle} from '../model/commentBundle';

@Injectable({
  providedIn: 'root'
})
export class RentingService {

  request: RentRequest;
  requestsForUser: Array<RentRequest> = new Array<RentRequest>();
  userRentedAds: Array<RentRequest> = new Array<RentRequest>();
  flag: boolean;
  // tslint:disable-next-line:align
  ads: Array<AdWithTimes> = new Array<AdWithTimes>();
  ad: AdWithTimes;

  constructor(private router: Router, private http: HttpClient, private userService: UserService) {

  }

  public getRentRequestsForUser(email: string): Array<RentRequest> {
    this.requestsForUser = new Array<RentRequest>();
    let params = new HttpParams();
    params = params.append('email', email);
    this.http.get(environment.gateway + environment.renting  + '/rentRequestsForUser', {params}).subscribe((data: RentRequest[]) => {
        console.log(data);
        this.requestsForUser = data;
      },
      error => {
        console.log(error);
      }
    );
    console.log(this.requestsForUser);
    return this.requestsForUser;
  }

  public getRequestsForUser() {
    return this.requestsForUser;
  }

  public rentOperation(operation: string, id: string) {
    let params = new HttpParams();
    params = params.append('operation', operation);
    params = params.append('id', id);
    return this.http.post(environment.gateway + environment.renting + '/rentOperation', params);
  }

  public getUserRentedAds(email: string) {
    this.userRentedAds = new Array<RentRequest>();
    let params = new HttpParams();
    params = params.append('email', email);
    this.http.get(environment.gateway + environment.renting  + '/userRentedAds', {params}).subscribe((data: RentRequest[]) => {
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
    const response: any = await this.http.get(environment.gateway + environment.renting + '/rateCarFlag', {params}).toPromise();
    return response;
  }

  public newCartAd(ad) {
    return this.http.post(environment.gateway + environment.renting + '/addToCart', ad);
  }

  public  getAllCart(): Array<AdWithTimes> {
    this.ads = new Array<AdWithTimes>();
    this.http.get(environment.gateway + environment.renting + '/allCart').subscribe((data: AdWithTimes[]) => {
        let flag = 0;
        for (const c of data) {
          flag = 0;
          this.ad = c;
          for (const t of this.ads) {
            if (c.ad.id === t.ad.id) {
              flag = 1;
            }
          }
          if (flag === 0) {
            this.ads.push(this.ad);
          }
        }
      },
      error => {
        console.log(error);
      }
    );
    return this.ads;
  }

  public getCartAds() {
    return this.ads;
  }

  public deleteCart() {
    let params = new HttpParams();
    params = params.append('email', this.userService.getLoggedUser().email);
    return  this.http.post(environment.gateway + environment.renting + '/deleteCart', params);
  }

  public comBundle(a: Array<CommentBundle>) {
    return this.http.post(environment.gateway + environment.renting + '/comBundle', a);
  }

}
