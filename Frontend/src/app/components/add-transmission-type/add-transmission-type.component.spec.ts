import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTransmissionTypeComponent } from './add-transmission-type.component';

describe('AddTransmissionTypeComponent', () => {
  let component: AddTransmissionTypeComponent;
  let fixture: ComponentFixture<AddTransmissionTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddTransmissionTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTransmissionTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
