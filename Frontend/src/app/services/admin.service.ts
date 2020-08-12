import { Injectable } from '@angular/core';
import {User} from '../model/user';
import {environment} from '../../environments/environment';
import {Router} from '@angular/router';
import {HttpClient, HttpParams} from '@angular/common/http';
import {AdWithTimes} from '../model/adWithTimes';
import {TOKEN} from './user.service';
import {Comment} from '../model/comment';
import {Client} from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  commentForOperations: Array<Comment> = new Array<Comment>();
  comment: Comment;
  com: Array<Comment> = new Array<Comment>();
  permissionsUsers: Array<Client> = new Array<Client>();
  constructor(private router: Router, private http: HttpClient) {
    this.commentForOperations = this.getCommentForOperation();
  }



  public getCommentForOperation(): Array<Comment> {
    console.log('usao u front');
    this.commentForOperations = new Array<Comment>();
    this.http.get(environment.gateway + environment.renting + '/allCommentsForOperation').subscribe((data: Comment[]) => {
        console.log(data);
        this.commentForOperations = data;
          //this.comment = new Comment(c.id , c.commenter, c.comment, c.approved, c.carRating, c.ad);


      },
      error => {
        console.log(error);
      }
    );
    console.log(this.commentForOperations);
    return this.commentForOperations;
  }

  public AccountOperation(operation: string, id: string) {
    console.log('usao u operacije na frontu');
    let params = new HttpParams();
    params = params.append('operation', operation);
    params = params.append('id', id);
    return this.http.post(environment.gateway + environment.renting + '/accountOperationForComment', params);
  }

  public getCommentsForOperation() {
    return this.commentForOperations;
  }

  public newAgent(client) {
    return this.http.post(environment.gateway + environment.admin  + '/addAgent', client);
  }

  public newFirm(client) {
    return this.http.post(environment.gateway + environment.admin  + '/addFirm', client);
  }

  public getClientsForPermissions(): Array<Client> {
    this.permissionsUsers = new Array<Client>();
    this.http.get(environment.gateway + environment.admin +  '/permissionsClients').subscribe((data: Client[]) => {
        console.log(data);
        this.permissionsUsers = data;
      },
      error => {
        console.log(error);
      }
    );
    console.log(this.permissionsUsers);
    return this.permissionsUsers;
  }

  public getPermissionUsers() {
    return this.permissionsUsers;
  }

  public permissionOperation(operation: string, id: string) {
    let params = new HttpParams();
    params = params.append('operation', operation);
    params = params.append('id', id);
    return this.http.post(environment.gateway + environment.admin  + '/permissionOperation', params);
  }

}

