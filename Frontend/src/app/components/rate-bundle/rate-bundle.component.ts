import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef, MatTableDataSource} from '@angular/material';
import {Ad} from '../../model/ad';
import {AdService} from '../../services/ad.service';
import {Router} from '@angular/router';
import {CommentBundle} from '../../model/commentBundle';
import {UserService} from '../../services/user.service';
import {RentingService} from '../../services/renting.service';
import {Car} from '../../model/car';

@Component({
  selector: 'app-rate-bundle',
  templateUrl: './rate-bundle.component.html',
  styleUrls: ['./rate-bundle.component.css']
})
export class RateBundleComponent implements OnInit {

  displayedColumns: string[] = ['carModel', 'carBrand', 'rate', 'comment'];
  dataSource = new MatTableDataSource<Car>();
  public rates: number[] = new Array();
  public comments: string[] = new Array();
  cmnts: Array<CommentBundle> = new Array<CommentBundle>();
  ads: Array<Car> = new Array<Car>();
  constructor(private adService: AdService,

              private router: Router, public dialog: MatDialog,
              private userService: UserService,
              @Inject(MAT_DIALOG_DATA) public data: any,
              private rentingService: RentingService,
              public dialogRef: MatDialogRef<RateBundleComponent>) {
    this.ads = data;
    this.dataSource = new MatTableDataSource<Car>(this.ads);
  }

  ngOnInit() {
  }

  save() {
    console.log(this.rates);
    for (let i = 0; i < this.rates.length; i++) {
      const r = new CommentBundle();
      r.email = this.userService.getLoggedUser().email;
      r.car = this.ads[i];
      r.rate = this.rates[i];
      r.comment = this.comments[i];
      console.log(r);
      this.cmnts.push(r);
      console.log(this.cmnts);
    }

    this.rentingService.comBundle(this.cmnts).subscribe(
      res => {
        alert('Commented');
        this.dialogRef.close();
      },
      error => {
        alert('Error');
      }
    );
  }

}
