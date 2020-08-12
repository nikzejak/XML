import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EndUserRentedCarsComponent } from './end-user-rented-cars.component';

describe('EndUserRentedCarsComponent', () => {
  let component: EndUserRentedCarsComponent;
  let fixture: ComponentFixture<EndUserRentedCarsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EndUserRentedCarsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EndUserRentedCarsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
