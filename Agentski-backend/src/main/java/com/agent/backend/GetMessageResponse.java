package com.agent.backend;

import com.agent.backend.model.CarBrand;
import com.agent.backend.model.Message;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "", propOrder = {
        "message"
})
@XmlRootElement(name = "getMessageResponse", namespace = "http://ftn.uns.ac.rs.tim13")
public class GetMessageResponse {

    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    protected Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
