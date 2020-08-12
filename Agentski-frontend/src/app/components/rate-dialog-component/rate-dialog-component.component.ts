import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Car} from '../../model/car';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Router} from '@angular/router';
import {UserService} from '../../services/user.service';
import {Comment} from '../../model/comment';
import {CommentService} from '../../services/comment.service';

export class Temp {
  comment: Comment;
  car: Car;
  mileage: number;
  carRating: number;
}

@Component({
  selector: 'app-rate-dialog-component',
  templateUrl: './rate-dialog-component.component.html',
  styleUrls: ['./rate-dialog-component.component.css']
})
export class RateDialogComponentComponent implements OnInit {

  RateFormGroup: FormGroup;
  comment: Comment;
  ret: Temp = new Temp();
  constructor(private formBuilder: FormBuilder,
              private dialogRef: MatDialogRef<RateDialogComponentComponent>,
              private commentService: CommentService,
              private router: Router,
              private userService: UserService,
              @Inject(MAT_DIALOG_DATA) public data) {
    console.log('Ispod data za dialog');
    console.log(data);
  }

  ngOnInit() {
    this.RateFormGroup = this.formBuilder.group({
      commentId: new FormControl(''),
      mileage: new FormControl(''),
      carRating: new FormControl('')
    });
  }

  get f() {
    return this.RateFormGroup.controls;
  }

  close() {
    this.dialogRef.close();
  }

  save() {
    if (this.RateFormGroup.invalid) {
      return;
    }

    this.comment = new Comment();
    this.comment.approved = true;
    this.comment.commenter = this.userService.getLoggedUser();
    this.comment.comment = this.f.commentId.value;
    this.comment.id = 0;
    this.ret.comment = this.comment;
    this.ret.mileage = this.f.mileage.value;
    this.ret.car = this.data.carsForRent[0];
    this.ret.carRating = this.f.carRating.value;

    this.commentService.newComment(this.ret).subscribe(
      data => {
        this.close();
      },
      error => {
        console.log(error);
      }
    );
  }

  }
