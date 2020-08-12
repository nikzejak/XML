import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EndUserAdsComponent } from './end-user-ads.component';

describe('EndUserAdsComponent', () => {
  let component: EndUserAdsComponent;
  let fixture: ComponentFixture<EndUserAdsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EndUserAdsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EndUserAdsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
