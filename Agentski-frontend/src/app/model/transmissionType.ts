export class TransmissionType {
  serialNumber: string;
  type: string;


  constructor(type: string, serialNumber?: string) {
    this.type = type;
    this.serialNumber = serialNumber;

  }
}
