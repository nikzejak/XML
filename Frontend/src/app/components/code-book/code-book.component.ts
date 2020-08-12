import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {NavigationEnd, Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {CarBrandService} from '../../services/car-brand.service';
import {CarBrand} from '../../model/carBrand';
import {CarModel} from '../../model/carModel';
import {CarModelService} from '../../services/car-model.service';
import {CarType} from '../../model/carType';
import {CarTypeService} from '../../services/car-type.service';
import {TransmissionTypeService} from '../../services/transmission-type.service';
import {TransmissionType} from '../../model/transmissionType';
import {FuelType} from '../../model/fuelType';
import {FuelTypeService} from '../../services/fuel-type.service';

@Component({
  selector: 'app-code-book',
  templateUrl: './code-book.component.html',
  styleUrls: ['./code-book.component.css']
})
export class CodeBookComponent implements OnInit {

  displayedColumns: string[] = ['brand', 'remove'];
  dataSource = new MatTableDataSource<CarBrand>();

  displayedColumns2: string[] = ['model'];
  dataSource2 = new MatTableDataSource<CarModel>();

  displayedColumns3: string[] = ['type'];
  dataSource3 = new MatTableDataSource<CarType>();

  displayedColumns4: string[] = ['type', 'serialNumber'];
  dataSource4 = new MatTableDataSource<TransmissionType>();

  displayedColumns5: string[] = ['type', 'serialNumber'];
  dataSource5 = new MatTableDataSource<FuelType>();

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor(
    public dialog: MatDialog,
    private router: Router,
    private carBrandService: CarBrandService,
    private carModelService: CarModelService,
    private carTypeService: CarTypeService,
    private transmissionTypeService: TransmissionTypeService,
    private fuelTypeService: FuelTypeService) {}

  ngOnInit() {
    this.all4();
    this.all5();
    this.all3();
    this.all2();
    this.all();
    this.dataSource.paginator = this.paginator;
    this.dataSource2.paginator = this.paginator;
    this.dataSource3.paginator = this.paginator;
    this.dataSource4.paginator = this.paginator;
    this.dataSource5.paginator = this.paginator;
  }

  all4() {
    this.dataSource = new MatTableDataSource<CarBrand>(this.carBrandService.getCarBrandsForOperations());

  }

  all5() {
    this.dataSource2 = new MatTableDataSource<CarModel>(this.carModelService.getAllCarModel());
  }

  all3() {
    this.dataSource3 = new MatTableDataSource<CarType>(this.carTypeService.getAllCarType());
  }

  all2() {
    this.dataSource4 = new MatTableDataSource<TransmissionType>(this.transmissionTypeService.getAllTransmissionType());
  }

  all() {
    this.dataSource5 = new MatTableDataSource<FuelType>(this.fuelTypeService.getAllFuelType());
  }

  function_for_operation(operation, el) {
    console.log(el.brand);
    this.carBrandService.AccountOperation(operation, el.brand).subscribe(data => {
        this.router.navigate(['/administrator/home']);


      },
      error => {
        console.log(error);
      });
  }

}
