import { Component, OnInit } from '@angular/core';
import {MatDialogRef, MatTableDataSource} from '@angular/material';
import {Ad} from '../../model/ad';
import {AdWithTimes} from '../../model/adWithTimes';
import {UserService} from '../../services/user.service';
import {AdService} from '../../services/ad.service';
import {OwnersAndIds} from '../../model/ownersAndIds';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {BundleModel} from '../../model/bundleModel';
import {EndUserHomePageComponent} from '../end-user-home-page/end-user-home-page.component';
import {RentingService} from '../../services/renting.service';

@Component({
  selector: 'app-cart-dialog',
  templateUrl: './cart-dialog.component.html',
  styleUrls: ['./cart-dialog.component.css']
})
export class CartDialogComponent implements OnInit {

  dataSource = new MatTableDataSource<AdWithTimes>();
  displayedColumns: string[] = ['title', 'startDate', 'endDate', 'reserve'];
  adWithTimes: AdWithTimes[];
  ows: OwnersAndIds[];
  owForm: FormGroup;
  ow: OwnersAndIds;
  bun: BundleModel;
 constructor(public dialogRef: MatDialogRef<CartDialogComponent>,
             public userService: UserService,
             private adService: AdService,
             private formBuilder: FormBuilder,
             private rentingService: RentingService) {
    this.adWithTimes = this.rentingService.getCartAds();
    console.log(this.adWithTimes);
    // this.ows = await this.adService.getOwners(this.adWithTimes);
    // console.log(this.ows);
    this.metoda();
    this.dataSource = new MatTableDataSource<AdWithTimes>(this.adWithTimes);
  }

  async metoda() {
    this.ows = await this.adService.getOwners(this.adWithTimes);
    console.log(this.ows);
  }

  ngOnInit() {
    this.owForm = this.formBuilder.group({
      clients: new FormControl('', [Validators.required]),
    });
  }

  close() {
    this.adWithTimes.splice(0, this.adWithTimes.length);
    this.ows.splice(0, this.ows.length);
    this.rentingService.deleteCart().subscribe(
      resl => {
        console.log('deleted');
      },
      error => {
        console.log('bad delete');
      }
    );
    this.dialogRef.close();
  }

  deleteRow(d) {
    const index = this.adWithTimes.indexOf(d);
    this.adWithTimes.splice(index, 1);
  }

  reserve(a: AdWithTimes) {
    this.adService.reserveAd(a).subscribe(
      res => {
        this.deleteRow(a);
        alert('Reserved');
        this.rentingService.deleteCart().subscribe(
          resl => {
            console.log('deleted');
          },
          error => {
            console.log('bad delete');
          }
        );
        this.close();
      },
      error => {
        alert('Error');
      }
    );
  }

  get f() {
    return this.owForm.controls;
  }


  onSubmit() {
    console.log(this.ows);
    if (this.owForm.invalid) {
      return;
    }

    for (const c of this.ows) {
      if (c.client.email === this.f.clients.value) {
        this.ow = c;
      }
    }
    this.bun = new BundleModel();
    this.bun.adsWithTimes = this.adWithTimes;


    this.adService.reserveBundle(this.bun).subscribe(
      res => {
        alert('Reserved');
        this.adWithTimes.splice(0, this.adWithTimes.length);
        this.ows.splice(0, this.ows.length);
        this.dialogRef.close();
        this.rentingService.deleteCart().subscribe(
          resl => {
            console.log('deleted');
          },
          error => {
           console.log('bad delete');
          }
        );
      },
      error => {
        alert('Error');
      }
    );

  }

}
