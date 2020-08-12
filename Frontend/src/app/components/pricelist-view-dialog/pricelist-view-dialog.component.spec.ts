import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PricelistViewDialogComponent } from './pricelist-view-dialog.component';

describe('PricelistViewDialogComponent', () => {
  let component: PricelistViewDialogComponent;
  let fixture: ComponentFixture<PricelistViewDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PricelistViewDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PricelistViewDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
