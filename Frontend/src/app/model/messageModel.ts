import {Car} from './car';

export class MessageModel {
  text: string;
  subject: string;
  email: string;
  cars: Car[];

  constructor(text: string, subject: string, email: string) {
    this.email = email;
    this.subject = subject;
    this.text = text;
  }
}
