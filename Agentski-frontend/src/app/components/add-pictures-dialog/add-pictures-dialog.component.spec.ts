import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPicturesDialogComponent } from './add-pictures-dialog.component';

describe('AddPicturesDialogComponent', () => {
  let component: AddPicturesDialogComponent;
  let fixture: ComponentFixture<AddPicturesDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddPicturesDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPicturesDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
