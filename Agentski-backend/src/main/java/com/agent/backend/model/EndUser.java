package com.agent.backend.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "EndUSer", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "email",
        "password",
        "firstName",
        "lastName",
        "jmbg",
        "phoneNumber"
})  //mozda dodati posle }, namespace = "nekiUri/end_user"

public class EndUser {

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

    public EndUser() {
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
}
