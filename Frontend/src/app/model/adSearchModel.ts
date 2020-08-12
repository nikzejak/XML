export class AdSearchModel {
  startDate: string;
  endDate: string;
  place: string;


  constructor(startDate: string, endDate: string, place: string) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.place = place;
  }
}
