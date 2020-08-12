package com.example.Xml.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String brand;

    @OneToMany(mappedBy = "carBrand")
    private Set<Car> cars;

    @OneToMany(mappedBy = "carBrand")
    private Set<CarModel> carModel;
}
