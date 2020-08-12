import { Component } from '@angular/core';
import {Observable} from 'rxjs';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { map, shareReplay } from 'rxjs/operators';
import {UserService} from './services/user.service';
import {MatDialog} from '@angular/material';
import {CartDialogComponent} from './components/cart-dialog/cart-dialog.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, private userService: UserService, public dialog: MatDialog) { }

  public isNone() {
    return this.userService.isNone();
  }
  public isAdministrator() {
    return this.userService.isAdministrator();
  }

  public isEndUser() {
    return this.userService.isEndUser();
  }

  public onLogout() {
    this.userService.logOut();
  }

  openDialog() {
    this.dialog.open(CartDialogComponent, {
      width: '50%', disableClose: true
    });
  }
}
