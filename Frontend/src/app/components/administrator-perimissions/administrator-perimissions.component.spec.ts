import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorPerimissionsComponent } from './administrator-perimissions.component';

describe('AdministratorPerimissionsComponent', () => {
  let component: AdministratorPerimissionsComponent;
  let fixture: ComponentFixture<AdministratorPerimissionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministratorPerimissionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorPerimissionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
