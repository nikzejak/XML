import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {Message} from '../../model/message';
import {MessageService} from '../../services/message.service';
import {Conversation} from '../../model/conversation';
import {ReplyMessageDialogComponent} from '../reply-message-dialog/reply-message-dialog.component';

@Component({
  selector: 'app-conversation-dialog',
  templateUrl: './conversation-dialog.component.html',
  styleUrls: ['./conversation-dialog.component.css']
})
export class ConversationDialogComponent implements OnInit {

  messages: Array<Message>;
  constructor(public dialogRef: MatDialogRef<ConversationDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data2: Conversation,
              public messageService: MessageService,
              public dialog: MatDialog) {
    this.messages = this.messageService.getConversation(this.data2.sender, this.data2.receiver);
  }

  ngOnInit() {
  }

  close() {
    this.dialogRef.close();
  }

  send() {
    this.dialogRef.close();
    setTimeout(() => {
      this.dialog.open(ReplyMessageDialogComponent, {
        width: '60%', disableClose: true, data: this.data2
      }); }, 200);
  }
}
