package com.agent.backend.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

//@XmlAccessorType(XmlAccessType.FIELD) ne znam da li ide i za enum kao i za obicne klase
@XmlType(
        name = "CarStatus", namespace = "http://ftn.uns.ac.rs.tim13"
)
@XmlEnum
public enum CarStatus {
    RENTED,
    NOT_RENTED
}
