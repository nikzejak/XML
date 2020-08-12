import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentConditionsComponent } from './rent-conditions.component';

describe('RentConditionsComponent', () => {
  let component: RentConditionsComponent;
  let fixture: ComponentFixture<RentConditionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentConditionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentConditionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
