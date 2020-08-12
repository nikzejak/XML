import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {CarType} from "../../model/carType";
import {CarBrand} from "../../model/carBrand";
import {Router} from "@angular/router";
import {CarTypeService} from "../../services/car-type.service";
import {CarBrandService} from "../../services/car-brand.service";

@Component({
  selector: 'app-add-car-brand',
  templateUrl: './add-car-brand.component.html',
  styleUrls: ['./add-car-brand.component.css']
})
export class AddCarBrandComponent implements OnInit {

  addCarBrandForm: FormGroup;
  submitted = false;
  carBrand: CarBrand;
  carBrands: Array<CarBrand> = new Array<CarBrand>();

  constructor(
    private formBuilder: FormBuilder,
    private  router: Router,
    private carBrandService: CarBrandService,
  ) {
    this.carBrands = this.carBrandService.getAllCarBrand();
  }

  ngOnInit() {
    this.addCarBrandForm = this.formBuilder.group({
      car_brand: new FormControl('', [Validators.required]),
    });
  }

  get f(){
    return this.addCarBrandForm.controls;
  }

  onSubmit(){
    this.submitted = true;

    if(this.addCarBrandForm.invalid){
      return;
    }

    this.carBrand = new CarBrand(
      this.f.car_brand.value,
    );
    this.carBrand = new CarBrand(this.f.car_brand.value);
    this.createCarBrand();
  }

  public createCarBrand(){
    this.carBrandService.newCarBrand(this.carBrand).subscribe(
      data => {
        this.carBrandService.addCarBrand(this.carBrand);
        this.router.navigate(['/administrator/home']);   //za ovo pitati
      },
      error => {
        alert('Error adding car brand');
        console.log(error);
      }
    );
  }
}
