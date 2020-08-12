package com.agent.backend.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(
        name = "RentRequestStatus", namespace = "http://ftn.uns.ac.rs.tim13"
)
@XmlEnum
public enum RentRequestStatus {
    PENDING,
    RESERVED,
    PAID,
    CANCELED
}
