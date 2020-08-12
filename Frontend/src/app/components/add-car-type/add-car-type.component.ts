import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {FuelType} from "../../model/fuelType";
import {CarType} from "../../model/carType";
import {Router} from "@angular/router";
import {FuelTypeService} from "../../services/fuel-type.service";
import {CarTypeService} from "../../services/car-type.service";

@Component({
  selector: 'app-add-car-type',
  templateUrl: './add-car-type.component.html',
  styleUrls: ['./add-car-type.component.css']
})
export class AddCarTypeComponent implements OnInit {

  addCarTypeForm: FormGroup;
  submitted = false;
  carType: CarType;
  carTypes: Array<CarType> = new Array<CarType>();

  constructor(
    private formBuilder: FormBuilder,
    private  router: Router,
    private carTypeService: CarTypeService,
  ) {
    this.carTypes = this.carTypeService.getAllCarType();
  }

  ngOnInit() {
    this.addCarTypeForm = this.formBuilder.group({
      car_type: new FormControl('', [Validators.required]),
    });
  }

  get f(){
    return this.addCarTypeForm.controls;
  }

  onSubmit(){
    this.submitted = true;

    if(this.addCarTypeForm.invalid){
      return;
    }

    this.carType = new CarType(
      this.f.car_type.value,
    );
    this.carType = new CarType(this.f.car_type.value);
    this.createCarType();
  }

  public createCarType(){
    this.carTypeService.newCarType(this.carType).subscribe(
      data => {
        this.carTypeService.addCarType(this.carType);
        this.router.navigate(['/administrator/home']);   //za ovo pitati
      },
      error => {
        alert('Error adding car type');
        console.log(error);
      }
    );
  }
}
