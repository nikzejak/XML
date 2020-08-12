package com.agent.backend.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Comment", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "commenter",
        "comment",
        "approved",
        "carRating",
        "ad"
})  //mozda dodati posle }, namespace = "nekiUri/comment"

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "commenter_id", nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private User commenter;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String comment;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private boolean approved = false;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private int carRating;


    @ManyToOne
    @JoinColumn(name = "ad_id")
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Ad ad;

    public Comment() {
    }

    public Comment(User commenter, String comment, boolean approved, int carRating, Ad ad) {
        this.commenter = commenter;
        this.comment = comment;
        this.approved = approved;
        this.carRating = carRating;
        this.ad = ad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getCarRating() {
        return carRating;
    }

    public void setCarRating(int carRating) {
        this.carRating = carRating;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commenter=" + commenter +
                ", comment='" + comment + '\'' +
                ", approved=" + approved +
                ", carRating=" + carRating +
                ", ad=" + ad +
                '}';
    }
}
