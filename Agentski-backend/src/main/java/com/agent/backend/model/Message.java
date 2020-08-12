package com.agent.backend.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Message", namespace = "http://ftn.uns.ac.rs.tim13", propOrder = {
        "id",
        "sender",
        "receiver",
        "text",
        "subject",
        "messageTime"
})  //mozda dodati posle }, namespace = "nekiUri/message"

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private User receiver;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String text;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private String subject;

    @Column
    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    private Date messageTime;


    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }
}
