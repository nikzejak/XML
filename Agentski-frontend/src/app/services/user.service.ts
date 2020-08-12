import { Injectable } from '@angular/core';
import {User} from '../model/user';
import {AdWithTimes} from '../model/adWithTimes';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Router} from '@angular/router';
import {Role} from '../model/role';
import {UserStatus} from '../model/userStatus';
import {environment} from '../../environments/environment';

export const TOKEN = 'LoggedInUser';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  users: Array<User> = new Array<User>();
  user: User = new User('', '', Role.NONE);
  endUser: User;
  allUser: User;
  userForLogin: User;
  endUsersForOperations: Array<User> = new Array<User>();
  adWithTimes: AdWithTimes[];
  constructor(private router: Router, private http: HttpClient) {
    localStorage.setItem(TOKEN, JSON.stringify(this.user));
    this.adWithTimes = new Array<AdWithTimes>();
    // this.endUsersForOperations = this.getEndUsersForOperations();
  }

  public isLoggedIn() {
    if (localStorage.getItem(TOKEN) !== null) {
      return localStorage.getItem(TOKEN);
    } else {
      return null;
    }
  }

  public logOut() {
    this.router.navigate(['']);
    this.user =  new User('', '', Role.NONE);
    localStorage.removeItem(TOKEN);
    localStorage.setItem(TOKEN, JSON.stringify(this.user));
  }

  public isNone() {
    if (this.isLoggedIn()) {
      return this.user.role === Role.NONE;
    }
  }

  public isAdministrator() {
    if (this.isLoggedIn()) {
      return this.user.role === Role.ADMINISTRATOR;
    }
  }

  public isAgent() {
    if (this.isLoggedIn()) {
      return this.user.role === Role.AGENT;
    }
  }

  public isEndUser() {
    if (this.isLoggedIn()) {
      return this.user.role === Role.ENDUSER;
    }
  }

  public whichRole(role: string) {
    if (role === 'ADMINISTRATOR') {
      return Role.ADMINISTRATOR;
    } else if (role === 'AGENT') {
      return Role.AGENT;
    } else if (role === 'ENDUSER') {
      return Role.ENDUSER;
    } else if (role === 'FIRM') {
      return Role.FIRM;
    } else {
      return null;
    }
  }

  public whichStatus(status: string) {
    if (status === 'ACCEPTED') {
      return UserStatus.ACCEPTED;
    } else if (status === 'AWAITING_APPROVAL') {
      return UserStatus.AWAITING_APPROVAL;
    } else if (status === 'BLOCKED') {
      return UserStatus.BLOCKED;
    } else if (status === 'REMOVED') {
      return UserStatus.REMOVED;
    } else {
      return null;
    }
  }


  public getAllUsers(): Array<User> {
    this.http.get(environment.url + environment.user + '/all').subscribe((data: User[]) => {
        for (const c of data) {
          console.log(c);
          this.allUser = new User(c.email, c.password, this.whichRole(c.role.toString()), this.whichStatus(c.status.toString()), c.id);
          this.users.push(this.allUser);
        }
      },
      error => {
        console.log(error);
      }
    );
    console.log(this.users);
    return this.users;
  }

  // public getUser(email: string): User {
  //   let params = new HttpParams();
  //   params = params.append('email', email);
  //   this.http.get(this.urlUser + '/userByEmail', {params}).subscribe((data: User) => {
  //     console.log(data);
  //     this.userForLogin = new User(data.email, data.password, this.whichRole(data.role.toString()),
  //     this.whichStatus(data.status.toString()), data.id);
  //   },
  //     error => {
  //       console.log(error);
  //     }
  //   );
  //   console.log(this.userForLogin);
  //   return this.userForLogin;
  // }


  public async getUser(email: string): Promise<User> {
    let params = new HttpParams();
    params = params.append('email', email);
    // tslint:disable-next-line:max-line-length
    const response: any = await this.http.get(environment.url + environment.user + '/userByEmail', {params}).toPromise();
    return response;
  }


  public setLoggedUser(user: User) {
    this.user = user;
  }

  public getLoggedUser() {
    return this.user;
  }


  public setToken(user) {
    localStorage.setItem(TOKEN, JSON.stringify(user));
    this.user = user;
  }
  public login(user) {
    console.log(user);
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.setToken(user);
    return this.http.post(environment.url + environment.user + '/login', user,  {responseType: 'text'});
  }

  public getEndUsersForOperations(): Array<User> {
    this.endUsersForOperations = new Array<User>();
    this.http.get(environment.url + environment.user + '/allEndUsersForOperations').subscribe((data: User[]) => {
        console.log(data);
        for (const c of data) {
          this.endUser = new User(c.email, c.password, this.whichRole(c.role.toString()), this.whichStatus(c.status.toString()), c.id);
          this.endUsersForOperations.push(this.endUser);
        }
      },
      error => {
        console.log(error);
      }
    );
    console.log(this.endUsersForOperations);
    return this.endUsersForOperations;
  }

  public AccountOperation(operation: string, id: string) {
    let params = new HttpParams();
    params = params.append('operation', operation);
    params = params.append('id', id);
    return this.http.post(environment.url + environment.user + '/accountOperation', params);
  }
  public getUsersForOperations() {
    return this.endUsersForOperations;
  }

  public addToList(ad: AdWithTimes) {
    let flag = 0;
    for (const c of this.adWithTimes) {
      if (c.ad.title === ad.ad.title) {
        flag = 1;
      }
    }
    if (flag === 0) {
      this.adWithTimes.push(ad);
    }

  }

  public getListCart() {
    return this.adWithTimes;
  }
}
