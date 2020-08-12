import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {MessageService} from "../../services/message.service";
import {UserService} from "../../services/user.service";
import {Message} from "../../model/message";
import {Conversation} from "../../model/conversation";

@Component({
  selector: 'app-reply-message-dialog',
  templateUrl: './reply-message-dialog.component.html',
  styleUrls: ['./reply-message-dialog.component.css']
})
export class ReplyMessageDialogComponent implements OnInit {
  private loginForm: FormGroup;
  private submitted = false;
  msg: Message;
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    public dialogRef: MatDialogRef<ReplyMessageDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Conversation,
    private messageService: MessageService,
    private userService: UserService) {
    this.msg = new Message();
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

    this.msg.receiver = this.data.receiver;
    this.msg.sender = this.data.sender;
    this.msg.subject = this.f.subject.value;
    this.msg.text = this.f.text.value;
    this.messageService.reply(this.msg).subscribe(
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
