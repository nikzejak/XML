import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RateDialogComponentComponent } from './rate-dialog-component.component';

describe('RateDialogComponentComponent', () => {
  let component: RateDialogComponentComponent;
  let fixture: ComponentFixture<RateDialogComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RateDialogComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RateDialogComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
