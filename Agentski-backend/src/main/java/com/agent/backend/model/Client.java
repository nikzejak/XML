package com.agent.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Client", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "email",
        "password",
        "firstName",
        "lastName",
        "jmbg",
        "phoneNumber",
        "personalID",
        "pib",
        "address",
        "role",
        "ads",
        "adCounter",
        "allowReservation"
})  //mozda dodati posle }, namespace = "nekiUri/client"

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @Column(nullable = false,unique = true)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String email;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String password;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String firstName;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String lastName;

    @Column(name = "jmbg", unique = true, nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String jmbg;

    @Column(name = "phone_number",nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String phoneNumber;

    //agent
    @Column(nullable = true)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String personalID;

    //firma
    @Column(nullable = true)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String pib;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String address;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Role role;

    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    @JsonIgnore
    private Set<Ad> ads;

    @Column(nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private int adCounter;

    @Column()
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private boolean allowReservation = true;

    public Client(){}


    //endUser
    public Client(String email,String password,String firstName,String lastName,String jmbg,String phoneNumber,String address) {
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.jmbg=jmbg;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.role=Role.ENDUSER;
        this.adCounter = 0;
        this.allowReservation = true;
    }

    //agent
    public Client(String email,String password,String firstName,String lastName,String jmbg,String phoneNumber,String address,String personalID) {
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.jmbg=jmbg;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.personalID=personalID;
        this.role=Role.AGENT;
        this.adCounter = 0;
    }

    //firm
    public Client(String email,String password,String firstName,String phoneNumber,String address,String pib) {
        this.email=email;
        this.firstName=firstName;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.pib=pib;
        this.role=Role.FIRM;
        this.adCounter = 0;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
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

    public int getAdCounter() {
        return adCounter;
    }

    public void setAdCounter(int adCounter) {
        this.adCounter = adCounter;
    }

    public boolean isAllowReservation() {
        return allowReservation;
    }

    public void setAllowReservation(boolean allowReservation) {
        this.allowReservation = allowReservation;
    }
}
