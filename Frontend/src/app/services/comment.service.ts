import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  public newComment(comment) {
    return this.http.post(environment.gateway + environment.renting + '/addComment', comment);
  }

}
