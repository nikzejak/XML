import {Component, OnInit, ViewChild} from '@angular/core';
import {User} from '../../model/user';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {AdminService} from '../../services/admin.service';
import {Client} from '../../model/client';
import {Router} from '@angular/router';

@Component({
  selector: 'app-administrator-perimissions',
  templateUrl: './administrator-perimissions.component.html',
  styleUrls: ['./administrator-perimissions.component.css']
})
export class AdministratorPerimissionsComponent implements OnInit {

  displayedColumns: string[] = ['email', 'name', 'surname', 'allowReservation', 'reservationCanceledCounter' , 'allow', 'disallow'];

  users: Array<User>;
  dataSource = new MatTableDataSource<Client>();
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  constructor(private adminService: AdminService,
              private router: Router) {
    this.dataSource = new MatTableDataSource(this.adminService.getPermissionUsers());
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit() {
  }

  function_for_operation(operation, user) {
    console.log(user.id.toString());
    this.adminService.permissionOperation(operation, user.id.toString()).subscribe(data => {
        this.router.navigate(['administrator/home']);
      },
      error => {
        console.log(error);
      });
  }

}
