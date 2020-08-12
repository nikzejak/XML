import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {PriceList} from '../../model/priceList';
import {PriceListService} from '../../services/price-list.service';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-add-price-list',
  templateUrl: './add-price-list.component.html',
  styleUrls: ['./add-price-list.component.css']
})
export class AddPriceListComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  priceList: PriceList;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private priceListService: PriceListService,
              private userService: UserService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      realPrice: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(6),
        Validators.pattern('[0-9]*')]),
      priceForMileage: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(3),
        Validators.pattern('[0-9]*')]),
      priceForCollisionDamageWavier: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(3),
        Validators.pattern('[0-9]*')]),
      discountAfterDays: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(3),
        Validators.pattern('[0-9]*')]),
    });
  }
  get f() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    // Stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    this.priceList = new PriceList();
    this.priceList.realPrice = this.f.realPrice.value;
    this.priceList.priceForMileage = this.f.priceForMileage.value;
    this.priceList.priceForCollisionDamageWavier = this.f.priceForCollisionDamageWavier.value;
    this.priceList.discountAfterDays = this.f.discountAfterDays.value;

    console.log(this.priceList);
    this.createPriceList();
  }

  private createPriceList() {
    this.priceListService.newPriceList(this.priceList, this.userService.getLoggedUser().email).subscribe(
      data => {
        this.router.navigate(['/agent/home']);
      },
      error => {
        console.log(error);
      }
    );
  }

}
