import { Injectable } from '@angular/core';
import {TransmissionType} from '../model/transmissionType';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {CarType} from '../model/carType';

@Injectable({
  providedIn: 'root'
})
export class TransmissionTypeService {
  listTransmissionTypes: Array<TransmissionType> = new Array<TransmissionType>();
  transmissionType: TransmissionType;

  constructor(private http: HttpClient, private transmissionTypeService: TransmissionTypeService) {
    this.getAllTransmissionType();
  }   // za ovo pitati


  public addTransmissionType(t: TransmissionType) {
    if (this.getTransmissionType(t.serialNumber) === null) {
      this.listTransmissionTypes.push(t);
    }
  }

  public getTransmissionType(serialNumber: string) {
    if (this.listTransmissionTypes.length === 0) {
      return null;
    }
    for (const u of this.listTransmissionTypes) {
      if (u.serialNumber === serialNumber) {
        return u;
      }
    }
    return null;
  }

  public getAllTransmissionType(): Array<TransmissionType> {
    this.http.get(environment.gateway + environment.admin + '/transmissionType/all').subscribe((data: TransmissionType[]) => {
        let flag = 0;
        for (const c of data) {
          flag = 0;
          this.transmissionType = new TransmissionType(c.type, c.serialNumber);
          for (const t of this.listTransmissionTypes) {
            if (c.type === t.type) {
              flag = 1;
            }
          }
          if (flag === 0) {
            this.listTransmissionTypes.push(this.transmissionType);
          }

        }
      },
      error => {
        console.log(error);
      });

    return this.listTransmissionTypes;
  }

  public newTransmissionType(transmissionType) {
    return this.http.post(environment.gateway + environment.admin + '/addTransmissionType', transmissionType);
  }
}
