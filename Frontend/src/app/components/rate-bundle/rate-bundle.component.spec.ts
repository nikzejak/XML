import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RateBundleComponent } from './rate-bundle.component';

describe('RateBundleComponent', () => {
  let component: RateBundleComponent;
  let fixture: ComponentFixture<RateBundleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RateBundleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RateBundleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
