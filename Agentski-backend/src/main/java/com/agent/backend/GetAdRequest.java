package com.agent.backend;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "", propOrder = {
                "id"
})
@XmlRootElement(name = "getAdRequest", namespace = "http://ftn.uns.ac.rs.tim13")
public class GetAdRequest {

    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
