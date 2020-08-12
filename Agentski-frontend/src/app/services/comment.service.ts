import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  public newComment(comment) {
    return this.http.post(environment.url + environment.renting + '/addComment', comment);
  }
  public carMileage(mileage) {
    return this.http.put(environment.url + environment.renting + '/addMileage', mileage);
  }
}
