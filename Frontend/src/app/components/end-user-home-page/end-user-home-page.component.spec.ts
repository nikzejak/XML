import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EndUserHomePageComponent } from './end-user-home-page.component';

describe('EndUserHomePageComponent', () => {
  let component: EndUserHomePageComponent;
  let fixture: ComponentFixture<EndUserHomePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EndUserHomePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EndUserHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
