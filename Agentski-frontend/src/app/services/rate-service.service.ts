import { Injectable } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RateServiceService {

  commentForOperations: Array<Comment> = new Array<Comment>();
  comment: Comment;
  constructor(private router: Router, private http: HttpClient) {
   // this.commentForOperations = this.getCommentForOperation();
  }

  public getCommentForOperation(): Array<Comment> {
    console.log('usao u front');
    this.commentForOperations = new Array<Comment>();
    this.http.get(environment.url + environment.renting + '/RateAndComment').subscribe((data: Comment[]) => {
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



  public getCommentsForOperation() {
    return this.commentForOperations;
  }
}
