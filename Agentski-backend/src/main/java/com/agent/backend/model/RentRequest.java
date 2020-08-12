package com.agent.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "RentRequest", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "reservedFrom",
        "reservedTo",
        "timeCreated",
        "rentRequestStatus",
        "carsForRent",
        "client"
})  //mozda dodati posle }, namespace = "nekiUri/rent_request"

public class RentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Date reservedFrom;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Date reservedTo;

    @JsonIgnore
    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private LocalDateTime timeCreated;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private RentRequestStatus rentRequestStatus;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Set<Car> carsForRent = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Client client;

    public RentRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReservedFrom() {
        return reservedFrom;
    }

    public void setReservedFrom(Date reservedFrom) {
        this.reservedFrom = reservedFrom;
    }

    public Date getReservedTo() {
        return reservedTo;
    }

    public void setReservedTo(Date reservedTo) {
        this.reservedTo = reservedTo;
    }

    public RentRequestStatus getRentRequestStatus() {
        return rentRequestStatus;
    }

    public void setRentRequestStatus(RentRequestStatus rentRequestStatus) {
        this.rentRequestStatus = rentRequestStatus;
    }

    public Set<Car> getCarsForRent() {
        return carsForRent;
    }

    public void setCarsForRent(Set<Car> carsForRent) {
        this.carsForRent = carsForRent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }
}
