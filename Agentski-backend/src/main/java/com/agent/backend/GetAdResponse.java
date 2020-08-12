package com.agent.backend;

import com.agent.backend.model.Ad;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "", propOrder = {
                "ad"
})
@XmlRootElement(name = "getAdResponse", namespace = "http://ftn.uns.ac.rs.tim13")
public class GetAdResponse {

    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    protected Ad ad;

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
