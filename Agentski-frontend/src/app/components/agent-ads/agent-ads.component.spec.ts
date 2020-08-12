import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentAdsComponent } from './agent-ads.component';

describe('AgentAdsComponent', () => {
  let component: AgentAdsComponent;
  let fixture: ComponentFixture<AgentAdsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentAdsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentAdsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
