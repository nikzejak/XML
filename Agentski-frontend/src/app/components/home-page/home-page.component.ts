import { Component, OnInit } from '@angular/core';
import {RateServiceService} from '../../services/rate-service.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private rateService: RateServiceService) {

  }

  ngOnInit() {
  }

}
