import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Router} from '@angular/router';
import {RateServiceService} from '../../services/rate-service.service';

@Component({
  selector: 'app-view-rate-and-comments',
  templateUrl: './view-rate-and-comments.component.html',
  styleUrls: ['./view-rate-and-comments.component.css']
})
export class ViewRateAndCommentsComponent implements OnInit {

  displayedColumns: string[] = ['id', 'adTitle', 'carBrand', 'carModel', 'comment', 'carRating'];

  dataSource = new MatTableDataSource<Comment>();

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(private rateService: RateServiceService, private router: Router) {
    this.dataSource = new MatTableDataSource(this.rateService.getCommentsForOperation());
    this.dataSource.paginator = this.paginator;

  }

  ngOnInit() {
  }

}
