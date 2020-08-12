package service.rentingService.dtos;

import service.rentingService.model.Ad;
import service.rentingService.model.Car;

public class RateBundleDTO {
    private Car car;
    private Number rate;
    private String comment;
    private String email;

    public RateBundleDTO() {
    }

    public RateBundleDTO(Car car, Number rate, String comment, String email) {
        this.car = car;
        this.rate = rate;
        this.comment = comment;
        this.email = email;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Number getRate() {
        return rate;
    }

    public void setRate(Number rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "RateBundleDTO{" +
                "car=" + car +
                ", rate=" + rate +
                ", comment='" + comment + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
