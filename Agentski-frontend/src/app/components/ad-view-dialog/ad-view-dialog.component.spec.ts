import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdViewDialogComponent } from './ad-view-dialog.component';

describe('AdViewDialogComponent', () => {
  let component: AdViewDialogComponent;
  let fixture: ComponentFixture<AdViewDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdViewDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdViewDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
