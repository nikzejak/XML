import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFuelTypeComponent } from './add-fuel-type.component';

describe('AddFuelTypeComponent', () => {
  let component: AddFuelTypeComponent;
  let fixture: ComponentFixture<AddFuelTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddFuelTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFuelTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
