package com.agent.backend.dtos;

import com.agent.backend.model.Car;

import java.util.List;

public class MessageDTO {
    private String text;
    private String subject;
    private String email;
    private Number id;

    public MessageDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }
}
