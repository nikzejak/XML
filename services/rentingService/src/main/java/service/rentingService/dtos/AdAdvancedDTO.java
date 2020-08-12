package service.rentingService.dtos;

import service.rentingService.model.Ad;

import java.util.List;

public class AdAdvancedDTO {
    private List<Ad> ads;
    private String carBrand;
    private String carModel;
    private String fuelType;
    private String transmissionType;
    private String carType;
    private Number price;
    private Number price2;
    private Boolean cdw;
    private Number childSeat;
    private Number mileage;
    private Number distanceAllowed;

    public AdAdvancedDTO() {
    }

    public AdAdvancedDTO(List<Ad> ads, String carBrand, String carModel, String fuelType, String transmissionType, String carType, Number price, Number price2, Boolean cdw, Number childSeat, Number mileage, Number distanceAllowed) {
        this.ads = ads;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.carType = carType;
        this.price = price;
        this.price2 = price2;
        this.cdw = cdw;
        this.childSeat = childSeat;
        this.mileage = mileage;
        this.distanceAllowed = distanceAllowed;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Number getPrice2() {
        return price2;
    }

    public void setPrice2(Number price2) {
        this.price2 = price2;
    }

    public Boolean getCdw() {
        return cdw;
    }

    public void setCdw(Boolean cdw) {
        this.cdw = cdw;
    }

    public Number getChildSeat() {
        return childSeat;
    }

    public void setChildSeat(Number childSeat) {
        this.childSeat = childSeat;
    }

    public Number getMileage() {
        return mileage;
    }

    public void setMileage(Number mileage) {
        this.mileage = mileage;
    }

    public Number getDistanceAllowed() {
        return distanceAllowed;
    }

    public void setDistanceAllowed(Number distanceAllowed) {
        this.distanceAllowed = distanceAllowed;
    }

    @Override
    public String toString() {
        return "AdAdvancedDTO{" +
                "ads=" + ads +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", carType='" + carType + '\'' +
                ", price=" + price +
                ", price2=" + price2 +
                ", cdw=" + cdw +
                ", childSeat=" + childSeat +
                ", mileage=" + mileage +
                ", distanceAllowed=" + distanceAllowed +
                '}';
    }
}
