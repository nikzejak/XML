export class FuelType {
  type: string;
  serialNumber: string;


  constructor(type: string, serialNumber?: string ) {
    this.type = type;
    this.serialNumber = serialNumber;
  }
}
