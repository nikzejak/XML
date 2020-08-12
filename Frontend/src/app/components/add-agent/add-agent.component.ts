import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Client} from '../../model/client';
import {User} from '../../model/user';
import {Router} from '@angular/router';
import {UserService} from '../../services/user.service';
import {AdminService} from '../../services/admin.service';
import {Role} from '../../model/role';

@Component({
  selector: 'app-add-agent',
  templateUrl: './add-agent.component.html',
  styleUrls: ['./add-agent.component.css']
})
export class AddAgentComponent implements OnInit {

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
      surname: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      number: new FormControl('', [Validators.required, Validators.minLength(9)]),
      insuranceID: new FormControl('', [Validators.required, Validators.minLength(13), Validators.maxLength(13)]),
      personalID: new FormControl('', [Validators.required, Validators.minLength(7), Validators.maxLength(7)]),
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
    this.client.personalID = this.f.personalID.value;
    this.client.role = Role.AGENT;
    this.client.adCounter = 0;

    this.creatAgent();
  }

  private creatAgent() {
    this.adminService.newAgent(this.client).subscribe(
      data => {
        this.router.navigate(['/administrator/home']);
      },
      error => {
        console.log(error);
      }
    );
  }

}
