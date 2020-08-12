package com.agent.backend.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.HashSet;
import java.util.Set;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "PriceList", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "realPrice",
        "priceForMileage",
        "priceForCollisionDamageWavier",
        "discountAfterDays",
        "ads",
        "client"

})  //mozda dodati posle }, namespace = "nekiUri/price_list"

public class PriceList {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private double realPrice;   //stvarna cena auta

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private double priceForMileage; //cena za kilometrazu

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private double priceForCollisionDamageWavier;   //cena za collision

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private int discountAfterDays;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Set<Ad> ads = new HashSet<>();

    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Client client;

    public PriceList() {
        this.discountAfterDays = 0;
    }

    public PriceList(double realPrice, double priceForMileage, double priceForCollisionDamageWavier, int discountAfterDays, Set<Ad> ads, Client client) {
        this.realPrice = realPrice;
        this.priceForMileage = priceForMileage;
        this.priceForCollisionDamageWavier = priceForCollisionDamageWavier;
        this.discountAfterDays = discountAfterDays;
        this.ads = ads;
        this.client = client;
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

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }

    public void setDiscountAfterDays(int discountAfterDays) {
        this.discountAfterDays = discountAfterDays;
    }

    public int getDiscountAfterDays() {
        return discountAfterDays;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
