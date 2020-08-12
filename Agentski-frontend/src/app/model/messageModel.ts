export class MessageModel {
  text: string;
  subject: string;
  email: string;
  id: number;

  constructor(text: string, subject: string, email: string, id: number) {
    this.email = email;
    this.subject = subject;
    this.text = text;
    this.id = id;
  }
}
