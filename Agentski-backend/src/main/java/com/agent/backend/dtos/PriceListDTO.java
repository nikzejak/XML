package com.agent.backend.dtos;

public class PriceListDTO {

    private double realPrice;
    private double priceForMileage;
    private double priceForCollisionDamageWavier;
    private int discountAfterDays;

    public double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }

    public double getPriceForMileage() {
        return priceForMileage;
    }

    public void setPriceForMileage(double priceForMileage) {
        this.priceForMileage = priceForMileage;
    }

    public double getPriceForCollisionDamageWavier() {
        return priceForCollisionDamageWavier;
    }

    public void setPriceForCollisionDamageWavier(double priceForCollisionDamageWavier) {
        this.priceForCollisionDamageWavier = priceForCollisionDamageWavier;
    }

    public int getDiscountAfterDays() {
        return discountAfterDays;
    }

    public void setDiscountAfterDays(int discountAfterDays) {
        this.discountAfterDays = discountAfterDays;
    }
}
