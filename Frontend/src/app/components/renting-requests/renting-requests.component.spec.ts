import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentingRequestsComponent } from './renting-requests.component';

describe('RentingRequestsComponent', () => {
  let component: RentingRequestsComponent;
  let fixture: ComponentFixture<RentingRequestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentingRequestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentingRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
