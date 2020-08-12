import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRateAndCommentsComponent } from './view-rate-and-comments.component';

describe('ViewRateAndCommentsComponent', () => {
  let component: ViewRateAndCommentsComponent;
  let fixture: ComponentFixture<ViewRateAndCommentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewRateAndCommentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRateAndCommentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
