import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {User} from '../../model/user';
import {UserService} from '../../services/user.service';
import {Role} from '../../model/role';
import {Router} from '@angular/router';
import {UserStatus} from '../../model/userStatus';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private loginForm: FormGroup;
  private submitted = false;
  private user: User;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  get f() {
    return this.loginForm.controls;
  }

  private onSubmit() {
    this.submitted = true;

    // Stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    // this.user = this.userService.getUser(this.f.email.value);
    // console.log(this.f.email.value);
    // console.log(this.user);
    // this.attemptLogin();
    this.reverse();
  }

  public whichRole(role: string) {
    if (role === 'ADMINISTRATOR') {
      return Role.ADMINISTRATOR;
    } else if (role === 'AGENT') {
      return Role.AGENT;
    } else if (role === 'ENDUSER') {
      return Role.ENDUSER;
    } else if (role === 'FIRM') {
      return Role.FIRM;
    } else {
      return null;
    }
  }

  public whichStatus(status: string) {
    if (status === 'ACCEPTED') {
      return UserStatus.ACCEPTED;
    } else if (status === 'AWAITING_APPROVAL') {
      return UserStatus.AWAITING_APPROVAL;
    } else if (status === 'BLOCKED') {
      return UserStatus.BLOCKED;
    } else if (status === 'REMOVED') {
      return UserStatus.REMOVED;
    } else {
      return null;
    }
  }

  async reverse() {
    const c = await this.userService.getUser(this.f.email.value);
    this.user = new User(c.email, c.password, this.whichRole(c.role.toString()), this.whichStatus(c.status.toString()), c.id);
    console.log(this.user);
    this.attemptLogin();

  }
  public attemptLogin() {
    if (this.user.role === Role.ADMINISTRATOR && this.f.email.value === this.user.email && this.f.password.value === this.user.password) {
      this.userService.login(this.user).subscribe(
        data => {
          if (data !== null) {
            this.userService.setLoggedUser(this.user);
            this.router.navigate(['/administrator/home']);
          } else {
            alert('Login error');
          }
        },
        error => {
          console.log(error);
        }
      );
    } else if (this.user.role === Role.ENDUSER && this.f.email.value === this.user.email && this.f.password.value === this.user.password) {
      this.userService.login(this.user).subscribe(
        data => {
            if (data !== null) {
              this.userService.setLoggedUser(this.user);
              this.router.navigate(['endUser/home']);
            } else {
              alert('Login error');
            }
        },
        error1 => {
          console.log(error1);
        }
      );
    } else if (this.user.role === Role.AGENT && this.f.email.value === this.user.email && this.f.password.value === this.user.password) {
      this.userService.login(this.user).subscribe(
        data => {
          if (data !== null) {
            this.userService.setLoggedUser(this.user);
            this.router.navigate(['agent/home']);
          } else {
            alert('Login error');
          }
        },
        error1 => {
          console.log(error1);
        }
      );
    }
  }
}
