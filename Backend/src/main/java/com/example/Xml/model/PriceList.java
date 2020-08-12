package com.example.Xml.model;

import javax.persistence.*;

@Entity
public class PriceList {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private double realPrice;   //stvarna cena auta

    @Column
    private double priceForMileage; //cena za kilometrazu

    @Column
    private double priceForCollisionDamageWavier;   //cena za collision

    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;  //oglas

    public PriceList() {
    }

    public PriceList(Long id, double realPrice, double priceForMileage, double priceForCollisionDamageWavier, Ad ad) {
        this.id = id;
        this.realPrice = realPrice;
        this.priceForMileage = priceForMileage;
        this.priceForCollisionDamageWavier = priceForCollisionDamageWavier;
        this.ad = ad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
