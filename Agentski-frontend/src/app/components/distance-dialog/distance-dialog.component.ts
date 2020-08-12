import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {CommentService} from '../../services/comment.service';
import {RentRequest} from '../../model/rentRequest';
import {Car} from '../../model/car';

export class Return {
  mileage: string;
  car: Car;
}

@Component({
  selector: 'app-distance-dialog',
  templateUrl: './distance-dialog.component.html',
  styleUrls: ['./distance-dialog.component.css']
})
export class DistanceDialogComponent implements OnInit {

  distanceFormGroup: FormGroup;
  req: RentRequest;
  r: Return = new Return();
  constructor(private formBuilder: FormBuilder,
              private dialogRef: MatDialogRef<DistanceDialogComponent>,
              private commentService: CommentService,
              @Inject(MAT_DIALOG_DATA) public data) {
    this.req = data;
    console.log('Ispod data za mileage');
    console.log(this.req);
  }

  ngOnInit() {
    this.distanceFormGroup = this.formBuilder.group({
      mileage: new FormControl('')
    });
  }

  get f() {
    return this.distanceFormGroup.controls;
  }

  close() {
    this.dialogRef.close();
  }

  save() {
    if (this.distanceFormGroup.invalid) {
      return;
    }
    // Samo za 1 auto
    for (const c of this.req.carsForRent) {
      this.r.car = c;
    }
    this.r.mileage = this.f.mileage.value;
    console.log('Ret ispod');
    console.log(this.r);
    this.commentService.carMileage(this.r).subscribe(
      data => {
        this.close();
      },
      error => {
        console.log(error);
      }
    );
  }



}
