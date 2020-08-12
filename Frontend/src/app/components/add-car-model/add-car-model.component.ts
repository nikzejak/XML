import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {CarBrand} from "../../model/carBrand";
import {CarModel} from "../../model/carModel";
import {Router} from "@angular/router";
import {CarBrandService} from "../../services/car-brand.service";
import {CarModelService} from "../../services/car-model.service";

@Component({
  selector: 'app-add-car-model',
  templateUrl: './add-car-model.component.html',
  styleUrls: ['./add-car-model.component.css']
})
export class AddCarModelComponent implements OnInit {

  addCarModelForm: FormGroup;
  submitted = false;
  carModel: CarModel;
  carModels: Array<CarModel> = new Array<CarModel>();

  constructor(
    private formBuilder: FormBuilder,
    private  router: Router,
    private carModelService: CarModelService,
  ) {
    this.carModels = this.carModelService.getAllCarModel();
  }

  ngOnInit() {
    this.addCarModelForm = this.formBuilder.group({
      car_model: new FormControl('', [Validators.required]),
    });
  }

  get f(){
    return this.addCarModelForm.controls;
  }
  onSubmit(){
    this.submitted = true;

    if(this.addCarModelForm.invalid){
      return;
    }

    this.carModel = new CarModel(
      this.f.car_model.value,
    );
    this.carModel = new CarModel(this.f.car_model.value);
    this.createCarModel();
  }

  public createCarModel(){
    this.carModelService.newCarModel(this.carModel).subscribe(
      data => {
        this.carModelService.addCarModel(this.carModel);
        this.router.navigate(['/administrator/home']);   //za ovo pitati
      },
      error => {
        alert('Error adding car model');
        console.log(error);
      }
    );
  }
}
