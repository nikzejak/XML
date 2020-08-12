import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentOperationComponent } from './comment-operation.component';

describe('CommentOperationComponent', () => {
  let component: CommentOperationComponent;
  let fixture: ComponentFixture<CommentOperationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommentOperationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommentOperationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
