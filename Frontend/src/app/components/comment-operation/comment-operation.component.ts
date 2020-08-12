import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Router} from '@angular/router';
import {AdminService} from '../../services/admin.service';
import {Comment} from '../../model/comment';

@Component({
  selector: 'app-comment-operation',
  templateUrl: './comment-operation.component.html',
  styleUrls: ['./comment-operation.component.css']
})
export class CommentOperationComponent implements OnInit {

  displayedColumns: string[] = ['id', 'adTitle', 'carBrand', 'carModel', 'comment', 'carRating', 'аccept', 'block'];

  dataSource = new MatTableDataSource<Comment>();
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private adminService: AdminService, private router: Router) {
  this.dataSource = new MatTableDataSource(this.adminService.getCommentsForOperation());
  this.dataSource.paginator = this.paginator;
  }

  ngOnInit() {
  }

  function_for_operation(operation, comment) {
    console.log(comment.id.toString());
    this.adminService.AccountOperation(operation, comment.id.toString()).subscribe(data => {
        this.router.navigate(['administrator/home']);
      },
      error => {
        console.log(error);
      });
  }


}
