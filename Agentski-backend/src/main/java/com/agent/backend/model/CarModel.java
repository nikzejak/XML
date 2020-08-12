package com.agent.backend.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "CarModel", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "model"
})  //mozda dodati posle }, namespace = "nekiUri/car_model"

public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String model;

    public CarModel() {
    }

    public CarModel(Long id, String model) {
        this.id = id;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String car_model) {
        this.model = car_model;
    }
}
