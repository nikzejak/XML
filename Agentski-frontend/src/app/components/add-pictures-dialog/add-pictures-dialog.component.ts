import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material';
import {AdService} from '../../services/ad.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Ad} from '../../model/ad';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-pictures-dialog',
  templateUrl: './add-pictures-dialog.component.html',
  styleUrls: ['./add-pictures-dialog.component.css']
})
export class AddPicturesDialogComponent implements OnInit {
  ad: Ad;
  images = [];
  myForm = new FormGroup({
    file: new FormControl('', [Validators.required]),
    fileSource: new FormControl('', [Validators.required])
  });

  constructor(public dialogRef: MatDialogRef<AddPicturesDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              public adService: AdService,
              public dialog: MatDialog,
              private router: Router,
              private http: HttpClient) {
  }

  ngOnInit() {
    this.ad = this.data;
    console.log(this.ad);
  }

  close() {
    this.dialogRef.close();
  }

  get f() {
    return this.myForm.controls;
  }

  onFileChange(event) {
    if (event.target.files && event.target.files[0]) {
      const filesAmount = event.target.files.length;
      for (let i = 0; i < filesAmount; i++) {
        const reader = new FileReader();

        // tslint:disable-next-line:no-shadowed-variable
        reader.onload = (event: any) => {
          console.log(event.target.result);
          this.images.push(event.target.result);

          this.myForm.patchValue({
            fileSource: this.images
          });
        };

        reader.readAsDataURL(event.target.files[i]);
      }
    }
  }

  submit() {
    console.log(this.myForm.value);
    let params = new HttpParams();
    params = params.append('title', this.data.title);
    this.http.post(environment.url + environment.ad + '/addPic', this.myForm.value, {params})
      .subscribe(res => {
        console.log(res);
        alert('Uploaded Successfully.');
        this.dialogRef.close();
        this.router.navigate(['/agent/home']);
      });
  }

}
