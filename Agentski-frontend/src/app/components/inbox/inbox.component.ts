import { Component, OnInit } from '@angular/core';
import {MatDialog, MatTableDataSource} from '@angular/material';
import {User} from '../../model/user';
import {Router} from '@angular/router';
import {UserService} from '../../services/user.service';
import {MessageService} from '../../services/message.service';
import {Conversation} from '../../model/conversation';
import {ConversationDialogComponent} from '../conversation-dialog/conversation-dialog.component';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit {
  displayedColumns: string[] = ['email', 'open'];
  DataSource = new MatTableDataSource<User>();
  conversation: Conversation;
  receivers: Array<User>;
  constructor(
    private router: Router,
    public dialog: MatDialog,
    private userService: UserService,
    private messageService: MessageService
  ) {
    this.conversation = new Conversation();
    console.log(this.receivers);
    this.receivers = this.messageService.getReceiversList();
    this.DataSource = new MatTableDataSource(this.receivers);
    console.log(this.receivers);
  }

  ngOnInit() {
  }

  async open(element) {
    this.conversation.receiver = element;
    this.conversation.sender = this.userService.getLoggedUser();
    setTimeout(() => {
      this.dialog.open(ConversationDialogComponent, {
        width: '90%', disableClose: true, data: this.conversation,
      });
    }, 200);
  }
}
