package com.agent.backend.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Firm", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "firmName",
        "pib",
        "address",
        "phoneNumber"
})  //mozda dodati posle }, namespace = "nekiUri/firm"

public class Firm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String firmName;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String pib;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String address;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String phoneNumber;

    public Firm() {
    }

    public Firm(String firmName, String pib, String address, String phoneNumber) {
        this.firmName = firmName;
        this.pib = pib;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
