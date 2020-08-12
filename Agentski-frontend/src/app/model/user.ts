import {Role} from './role';
import {UserStatus} from './userStatus';

export class User {

  id: number;
  email: string;
  password: string;
  role: Role;
  status: UserStatus;

  constructor(email: string, password: string, role: Role, status?: UserStatus, id?: number) {
    this.email = email;
    this.password = password;
    this.role = role;
    this.status = status;
    this.id = id;
  }

  public setAll(email: string, password: string, role: Role, status?: UserStatus, id?: number) {
    this.email = email;
    this.password = password;
    this.role = role;
    this.status = status;
    this.id = id;
  }


}
