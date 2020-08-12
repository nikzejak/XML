package com.example.Xml.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_brand_id", nullable = false)
    private CarBrand carBrand;

    @Column(nullable = false)
    private CarType carType;

    @Column(nullable = false)
    private String fuelType;

    @Column(nullable = false)
    private String transmissionType;

    @Column(nullable = false)
    @Range(min = 0, max = 1000000)
    private int price;

    @Column(nullable = false)
    private int discount;

    @Column(nullable = false)
    @Range(min = 0, max = 1000000)
    private float mileage;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;

    @Column(nullable = false)
    private float distanceAllowed;

    @Column(nullable = false)
    private boolean collisionDamageWaiver = false;

    @Column(nullable = false)
    @Range(min = 0, max = 5)
    private int childSeats;

    @Column(nullable = false)
    private double averageRating = 0;

    public Car(Long id, CarBrand carBrand, CarType carType, String fuelType, String transmissionType, @Range(min = 0, max = 1000000) int price, int discount, @Range(min = 0, max = 1000000) float mileage, CarStatus carStatus, float distanceAllowed, boolean collisionDamageWaiver, @Range(min = 0, max = 5) int childSeats, double averageRating) {
        this.id = id;
        this.carBrand = carBrand;
        this.carType = carType;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.price = price;
        this.discount = discount;
        this.mileage = mileage;
        this.carStatus = carStatus;
        this.distanceAllowed = distanceAllowed;
        this.collisionDamageWaiver = collisionDamageWaiver;
        this.childSeats = childSeats;
        this.averageRating = averageRating;
    }

    public Car() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public float getDistanceAllowed() {
        return distanceAllowed;
    }

    public void setDistanceAllowed(float distanceAllowed) {
        this.distanceAllowed = distanceAllowed;
    }

    public int getChildSeats() {
        return childSeats;
    }

    public void setChildSeats(int childSeats) {
        this.childSeats = childSeats;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
}
