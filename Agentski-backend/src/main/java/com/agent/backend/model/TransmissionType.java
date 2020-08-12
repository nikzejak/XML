package com.agent.backend.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "TransmissionType", namespace = "http://ftn.uns.ac.rs.tim13",propOrder = {
        "id",
        "serialNumber",
        "type"
})  //mozda dodati posle }, namespace = "nekiUri/transmission_type"

public class TransmissionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String serialNumber;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String type;

    public TransmissionType(Long id, String serialNumber, String type) {
        this.id = id;
        this.type = type;
        this.serialNumber = serialNumber;
    }

    public TransmissionType() {
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

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
