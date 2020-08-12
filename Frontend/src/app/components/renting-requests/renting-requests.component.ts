import {Component, OnInit, ViewChild} from '@angular/core';
import {User} from '../../model/user';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {RentRequest} from '../../model/rentRequest';
import {RentingService} from '../../services/renting.service';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-renting-requests',
  templateUrl: './renting-requests.component.html',
  styleUrls: ['./renting-requests.component.css']
})
export class RentingRequestsComponent implements OnInit {

  displayedColumns: string[] = ['id', 'reservedFrom', 'reservedTo', 'cars', 'аccept', 'decline'];

  users: Array<User>;
  dataSource = new MatTableDataSource<RentRequest>();
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private rentRequestService: RentingService,
              private userService: UserService,
              private router: Router) {
    this.dataSource = new MatTableDataSource(rentRequestService.getRequestsForUser());
  }

  ngOnInit() {
  }

  function_for_operation(operation, request) {
    this.rentRequestService.rentOperation(operation, request.id.toString()).subscribe(data => {
        this.router.navigate(['endUser/home']);
      },
      error => {
        console.log(error);
      });
  }

  carsToString(request: RentRequest) {
    let ret = '';
    for (const r of request.carsForRent) {
      ret = r.carModel.model + ',';
    }
    ret = ret.substring(0, ret.length - 1);
    return ret;
  }


}
