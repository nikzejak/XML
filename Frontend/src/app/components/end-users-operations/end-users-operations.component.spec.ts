import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EndUsersOperationsComponent } from './end-users-operations.component';

describe('EndUsersOperationsComponent', () => {
  let component: EndUsersOperationsComponent;
  let fixture: ComponentFixture<EndUsersOperationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EndUsersOperationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EndUsersOperationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
