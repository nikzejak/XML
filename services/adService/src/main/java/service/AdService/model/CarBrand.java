package service.AdService.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    public CarBrand() {
    }
/*
    public CarBrand(Long id, String brand) {
        this.id = id;
        this.brand = brand;
    }
*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "CarBrand{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}
