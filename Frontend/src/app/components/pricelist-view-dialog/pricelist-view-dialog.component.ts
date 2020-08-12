import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {PriceList} from '../../model/priceList';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-pricelist-view-dialog',
  templateUrl: './pricelist-view-dialog.component.html',
  styleUrls: ['./pricelist-view-dialog.component.css']
})
export class PricelistViewDialogComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  priceList: PriceList;
  constructor(public dialogRef: MatDialogRef<PricelistViewDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public datas: any,
              private formBuilder: FormBuilder) {
    this.priceList = datas;
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      realPrice: new FormControl(this.priceList.realPrice),
      priceForMileage: new FormControl(this.priceList.priceForMileage),
      priceForCollisionDamageWavier: new FormControl(this.priceList.priceForCollisionDamageWavier),
      discountAfterDays: new FormControl(this.priceList.discountAfterDays),
    });
  }

  onSubmit() {}
  close() {
    this.dialogRef.close();
  }

}
