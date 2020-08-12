import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentRentedCarsComponent } from './agent-rented-cars.component';

describe('AgentRentedCarsComponent', () => {
  let component: AgentRentedCarsComponent;
  let fixture: ComponentFixture<AgentRentedCarsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentRentedCarsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentRentedCarsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
