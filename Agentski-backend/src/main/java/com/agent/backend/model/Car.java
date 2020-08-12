package com.agent.backend.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Car", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "carBrand",
        "carModel",
        "carType",
        "fuelType",
        "transmissionType",
        "discount",
        "mileage",
        "carStatus",
        "distanceAllowed",
        "collisionDamageWaiver",
        "childSeats",
        "averageRating",
        "commentCount"
})  //mozda dodati posle }, namespace = "nekiUri/car"

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @ManyToOne
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private CarBrand carBrand;

    @ManyToOne
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private CarModel carModel;

    @OneToOne
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private CarType carType;

    @ManyToOne
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private FuelType fuelType;

    @ManyToOne
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private TransmissionType transmissionType;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private int discount;

    @Column(nullable = false)
    @Range(min = 0, max = 1000000)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private float mileage;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private CarStatus carStatus;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private float distanceAllowed;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private boolean collisionDamageWaiver = false;

    @Column(nullable = false)
    @Range(min = 0, max = 5)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private int childSeats;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private double averageRating = 0;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private int commentCount = 0;

    public Car(CarBrand carBrand, CarModel carModel, CarType carType, FuelType fuelType, TransmissionType transmissionType, int discount, @Range(min = 0, max = 1000000) float mileage, CarStatus carStatus, float distanceAllowed, boolean collisionDamageWaiver, @Range(min = 0, max = 5) int childSeats, double averageRating, int commentCount) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carType = carType;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.discount = discount;
        this.mileage = mileage;
        this.carStatus = carStatus;
        this.distanceAllowed = distanceAllowed;
        this.collisionDamageWaiver = collisionDamageWaiver;
        this.childSeats = childSeats;
        this.averageRating = averageRating;
        this.commentCount = commentCount;
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

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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

    public boolean isCollisionDamageWaiver() {
        return collisionDamageWaiver;
    }

    public void setCollisionDamageWaiver(boolean collisionDamageWaiver) {
        this.collisionDamageWaiver = collisionDamageWaiver;
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

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
