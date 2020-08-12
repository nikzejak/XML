package service.AdService.model;


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_brand_id", nullable = false)
    private CarBrand carBrand;

    @ManyToOne
    private CarModel carModel;

    @OneToOne
    private CarType carType;

    @ManyToOne
    private FuelType fuelType;

    @ManyToOne
    private TransmissionType transmissionType;

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

    public Car(CarBrand carBrand, CarModel carModel, CarType carType, FuelType fuelType, TransmissionType transmissionType, int discount, @Range(min = 0, max = 1000000) float mileage, CarStatus carStatus, float distanceAllowed, boolean collisionDamageWaiver, @Range(min = 0, max = 5) int childSeats, double averageRating) {
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carBrand=" + carBrand.toString() +
                ", carModel=" + carModel.toString() +
                ", carType=" + carType.toString() +
                ", fuelType=" + fuelType.toString() +
                ", transmissionType=" + transmissionType.toString() +
                ", discount=" + discount +
                ", mileage=" + mileage +
                ", carStatus=" + carStatus +
                ", distanceAllowed=" + distanceAllowed +
                ", collisionDamageWaiver=" + collisionDamageWaiver +
                ", childSeats=" + childSeats +
                ", averageRating=" + averageRating +
                '}';
    }
}
