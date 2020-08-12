import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {User} from '../../model/user';
import {Client} from '../../model/client';
import {Router} from '@angular/router';
import {Role} from '../../model/role';
import {AdminService} from '../../services/admin.service';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  client: Client;
  user: User;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private userService: UserService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(8),
        Validators.pattern('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$')]),
      name: new FormControl('', [Validators.required]),
      surname: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      number: new FormControl('', [Validators.required, Validators.minLength(9)]),
      insuranceID: new FormControl('', [Validators.required, Validators.minLength(13), Validators.maxLength(13)]),
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
    this.client.lastName = this.f.surname.value;
    this.client.email = this.f.email.value;
    this.client.password = this.f.password.value;
    this.client.address = this.f.address.value;
    this.client.phoneNumber = this.f.number.value;
    this.client.jmbg = this.f.insuranceID.value;
    this.client.role = Role.ENDUSER;
    this.client.adCounter = 0;

    this.createUser();
  }

  private createUser() {
    this.userService.newUser(this.client).subscribe(
      data => {
        this.router.navigate(['/login']);
        alert('Successful register');
      },
      error => {
        alert('Error registration');
        console.log(error);
      }
    );
  }

}
