package com.agent.backend.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "FuelType", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "type",
        "serialNumber"
})  //mozda dodati posle }, namespace = "nekiUri/fuel_type"

public class FuelType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String type;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String serialNumber;

    public FuelType() {
    }

    public FuelType(Long id, String type, String serialNumber) {
        this.id = id;
        this.type = type;
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerial_number(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String fuelType) {
        this.type = fuelType;
    }
}
