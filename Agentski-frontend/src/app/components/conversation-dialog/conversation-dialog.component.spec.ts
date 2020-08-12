import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConversationDialogComponent } from './conversation-dialog.component';

describe('ConversationDialogComponent', () => {
  let component: ConversationDialogComponent;
  let fixture: ComponentFixture<ConversationDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConversationDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConversationDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
