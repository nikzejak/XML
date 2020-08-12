import { Injectable } from '@angular/core';
import {User} from '../model/user';
import {Message} from '../model/message';
import {Router} from '@angular/router';
import {HttpClient, HttpParams} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {MessageModel} from '../model/messageModel';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  receivers: Array<User> = new Array<User>();
  rec: User;
  mes: Message;
  messages: Array<Message> = new Array<Message>();

  constructor(private router: Router, private http: HttpClient) { }

  public getConversation(us: User, uu: User): Array<Message> {
    console.log('usao sam' + us.email);
    let params = new HttpParams();
    params = params.append('email', us.email);
    params = params.append('email2', uu.email);
    this.messages = new Array<Message>();
    this.http.get(environment.url + environment.message + '/getConversation', {params}).subscribe((data: Message[]) => {
        for (const c of data) {
          this.mes = c;
          this.messages.push(this.mes);
        }
      },
      error1 => {
        console.log(error1);
      }
    );
    return this.messages;
  }

  public sendMessage(mess: MessageModel) {
    return this.http.post(environment.url + environment.message + '/send', mess);
  }


  public reply(mes: Message) {
    return this.http.post(environment.url + environment.message + '/reply', mes);
  }

  public getReceivers(us: User): Array<User> {
    console.log('usao sam' + us.email);
    let params = new HttpParams();
    params = params.append('email', us.email);
    this.receivers = new Array<User>();
    this.http.get(environment.url + environment.message + '/getReceivers', {params}).subscribe((data: User[]) => {
        for (const c of data) {
          this.rec = c;
          this.receivers.push(this.rec);
        }
      },
      error1 => {
        console.log(error1);
      }
    );
    return this.receivers;
  }

  public getReceiversList() {
    return this.receivers;
  }
}
