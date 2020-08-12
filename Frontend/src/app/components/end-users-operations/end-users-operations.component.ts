import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {User} from '../../model/user';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-end-users-operations',
  templateUrl: './end-users-operations.component.html',
  styleUrls: ['./end-users-operations.component.css']
})
export class EndUsersOperationsComponent implements OnInit {

  displayedColumns: string[] = ['id', 'email', 'role', 'status', 'аccept', 'block', 'remove'];

  users: Array<User>;
  dataSource = new MatTableDataSource<User>();
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private userService: UserService, private router: Router) {
    this.dataSource = new MatTableDataSource(this.userService.getUsersForOperations());
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit() {
  }

  role_to_string(role) {
    if (role === 0) {
      return 'Administrator';
    } else if (role === 1) {
      return 'End user';
    } else if (role === 2) {
      return 'Firm';
    } else {
      return 'Agent';
    }
  }

  status_to_string(status) {
    if (status === 0) {
      return 'Accepted';
    } else if (status === 1) {
      return 'Awaiting approval';
    } else if (status === 2) {
      return 'Blocked';
    } else {
      return 'Removed';
    }

  }
  function_for_operation(operation, user) {
    console.log(user.id.toString());
    this.userService.AccountOperation(operation, user.id.toString()).subscribe(data => {
      this.router.navigate(['administrator/home']);
    },
      error => {
        console.log(error);
      });
  }

}
