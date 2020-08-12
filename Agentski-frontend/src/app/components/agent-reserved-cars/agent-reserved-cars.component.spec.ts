import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentReservedCarsComponent } from './agent-reserved-cars.component';

describe('AgentReservedCarsComponent', () => {
  let component: AgentReservedCarsComponent;
  let fixture: ComponentFixture<AgentReservedCarsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentReservedCarsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentReservedCarsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
