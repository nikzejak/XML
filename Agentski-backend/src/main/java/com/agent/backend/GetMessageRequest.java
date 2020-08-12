package com.agent.backend;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "", propOrder = {
        "id"
})
@XmlRootElement(name = "getMessageRequest", namespace = "http://ftn.uns.ac.rs.tim13")
public class GetMessageRequest {

    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
