package service.rentingService.dtos;

import service.rentingService.model.Ad;

public class AdRentDTO {
    Ad ad;
    String startTime;
    String endTime;

    public AdRentDTO() {
    }

    public AdRentDTO(Ad ad, String startTime, String endTime) {
        this.ad = ad;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "AdRentDTO{" +
                "ad=" + ad.toString() +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
