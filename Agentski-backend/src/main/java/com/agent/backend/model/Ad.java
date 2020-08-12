package com.agent.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.Set;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Ad", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "car",
        "profilePicture",
        "title",
        "client",
        "startOfAd",
        "endOfAd",
        "description",
        "isActive",
        "currentDriver",
        "comments",
        "place"
})  //mozda dodati posle }, namespace = "nekiUri/ad"

public class Ad {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Car car;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String profilePicture;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String title;

//    @JsonIgnore
//    @OneToMany(mappedBy = "ad",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
//    private Set<Picture> pictureSet;

    //client
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Date startOfAd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Date endOfAd;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String description;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private boolean isActive;


    @OneToOne(fetch = FetchType.EAGER)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Client currentDriver;

    @JsonIgnore
    @OneToMany(mappedBy = "ad",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Set<Comment> comments;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String place;

    public Ad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

//    public Set<Picture> getPictureSet() {
//        return pictureSet;
//    }
//
//    public void setPictureSet(Set<Picture> pictureSet) {
//        this.pictureSet = pictureSet;
//    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getStartOfAd() {
        return startOfAd;
    }

    public void setStartOfAd(Date startOfAd) {
        this.startOfAd = startOfAd;
    }

    public Date getEndOfAd() {
        return endOfAd;
    }

    public void setEndOfAd(Date endOfAd) {
        this.endOfAd = endOfAd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Client getCurrentDriver() {
        return currentDriver;
    }

    public void setCurrentDriver(Client currentDriver) {
        this.currentDriver = currentDriver;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", car=" + car +
                ", profilePicture='" + profilePicture + '\'' +
                ", title='" + title + '\'' +
                ", client=" + client +
                ", startOfAd=" + startOfAd +
                ", endOfAd=" + endOfAd +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", place='" + place + '\'' +
                '}';
    }
}
