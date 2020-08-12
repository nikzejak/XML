import {User} from './user';

export class Message {
  sender: User;
  receiver: User;
  text: string;
  subject: string;

  constructor() {}
}
