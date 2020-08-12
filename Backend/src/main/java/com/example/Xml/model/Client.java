package com.example.Xml.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(name = "jmbg", unique = true, nullable = false)
    private String jmbg;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    //agent
    @Column(nullable = false)
    private String personalID;
    //firma
    @Column(nullable = false)
    private String pib;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Ad> ads;


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
}
