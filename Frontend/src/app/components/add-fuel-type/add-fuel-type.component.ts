import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {FuelType} from "../../model/fuelType";
import {Router} from "@angular/router";
import {AdminService} from "../../services/admin.service";
import {error} from "util";
import {environment} from "../../../environments/environment";
import {FuelTypeService} from "../../services/fuel-type.service";

@Component({
  selector: 'app-add-fuel-type',
  templateUrl: './add-fuel-type.component.html',
  styleUrls: ['./add-fuel-type.component.css']
})
export class AddFuelTypeComponent implements OnInit {

  addFuelTypeForm: FormGroup;
  submitted = false;
  fuelType: FuelType;
  fuelTypes: Array<FuelType> = new Array<FuelType>();

  constructor(
    private formBuilder: FormBuilder,
    private  router: Router,
    private fuelTypeService: FuelTypeService,
  ) {
    this.fuelTypes = this.fuelTypeService.getAllFuelType();
  }

  serialNumber: string;
  type: string;

  ngOnInit() {
    this.addFuelTypeForm = this.formBuilder.group({
      serialNumber: new FormControl('', [Validators.required]),
      type: new FormControl('', [Validators.required]),
    });
  }

  get f(){
    return this.addFuelTypeForm.controls;
  }

  onSubmit(){
    this.submitted = true;

    if(this.addFuelTypeForm.invalid){
      return;
    }

    this.fuelType = new FuelType(
      this.f.type.value,
      this.f.serialNumber.value,
    );
    this.fuelType = new FuelType( this.f.type.value, this.f.serialNumber.value);
    this.createFuelType();
  }

  private createFuelType(){
    this.fuelTypeService.newFuelType(this.fuelType).subscribe(
      data => {
        this.fuelTypeService.addFuelType(this.fuelType);
        this.router.navigate(['/administrator/home']);   //za ovo pitati
      },
      error => {
        alert('Error adding fuel type');
        console.log(error);
      }
    );
  }

}
