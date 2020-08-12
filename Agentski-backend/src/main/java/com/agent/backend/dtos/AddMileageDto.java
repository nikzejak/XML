package com.agent.backend.dtos;

import com.agent.backend.model.Car;

public class AddMileageDto {
    private String mileage;
    private Car car;

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
