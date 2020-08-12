import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MessageModel} from '../../model/messageModel';
import {Router} from '@angular/router';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {MessageService} from '../../services/message.service';
import {UserService} from '../../services/user.service';
import {Message} from '../../model/message';

@Component({
  selector: 'app-send-message-dialog',
  templateUrl: './send-message-dialog.component.html',
  styleUrls: ['./send-message-dialog.component.css']
})
export class SendMessageDialogComponent implements OnInit {
  private loginForm: FormGroup;
  private submitted = false;
  messageModel: MessageModel;
  message: Message;
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    public dialogRef: MatDialogRef<SendMessageDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public dataId: any,
    private messageService: MessageService,
    private userService: UserService) {
    this.messageModel = new MessageModel('', '', '', dataId);
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      subject: ['', Validators.required],
      text: ['', Validators.required]
    });
  }
  get f() {
    return this.loginForm.controls;
  }

  close() {
    this.dialogRef.close();

  }

  private onSubmit() {
    this.submitted = true;

    // Stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    this.messageModel.subject = this.f.subject.value;
    this.messageModel.text = this.f.text.value;
    this.messageModel.email = this.userService.getLoggedUser().email;
    console.log(this.messageModel);
    this.messageService.sendMessage(this.messageModel).subscribe(
      res => {
        alert('Sent');
        this.dialogRef.close();
      },
      error => {
        alert('Error');
      }
    );
  }
}
