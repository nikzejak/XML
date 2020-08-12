import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Client} from '../../model/client';
import {User} from '../../model/user';
import {Router} from '@angular/router';
import {AdminService} from '../../services/admin.service';
import {Role} from '../../model/role';

@Component({
  selector: 'app-add-firm',
  templateUrl: './add-firm.component.html',
  styleUrls: ['./add-firm.component.css']
})
export class AddFirmComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  client: Client;
  user: User;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private adminService: AdminService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(8),
        Validators.pattern('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$')]),
      name: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      number: new FormControl('', [Validators.required, Validators.minLength(9)]),
      pib: new FormControl('', [Validators.required, Validators.minLength(7), Validators.maxLength(10)]),
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

    this.client = new Client();
    this.client.firstName = this.f.name.value;
    this.client.email = this.f.email.value;
    this.client.password = this.f.password.value;
    this.client.address = this.f.address.value;
    this.client.phoneNumber = this.f.number.value;
    this.client.pib = this.f.pib.value;
    this.client.role = Role.FIRM;
    this.client.adCounter = 0;

    this.createFirm();
  }

  private createFirm() {
    this.adminService.newFirm(this.client).subscribe(
      data => {
        this.router.navigate(['/administrator/home']);
      },
      error => {
        console.log(error);
      }
    );
  }

}
