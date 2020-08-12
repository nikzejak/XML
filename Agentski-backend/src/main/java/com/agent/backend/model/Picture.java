package com.agent.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Data
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Picture", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "picture",
        "ad",
        "isDeleted"
})  //mozda dodati posle }, namespace = "nekiUri/picture"

public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Ad ad;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private boolean isDeleted;

    public Picture() {
    }
}
