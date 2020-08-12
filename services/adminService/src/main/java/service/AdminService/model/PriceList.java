package service.AdminService.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Ad> ads = new HashSet<>();

    public PriceList() {
    }

    public PriceList(double realPrice, double priceForMileage, double priceForCollisionDamageWavier, Set<Ad> ads) {
        this.realPrice = realPrice;
        this.priceForMileage = priceForMileage;
        this.priceForCollisionDamageWavier = priceForCollisionDamageWavier;
        this.ads = ads;
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
}
