package service.AdminService.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(
        name = "UserStatus", namespace = "http://ftn.uns.ac.rs.tim13"
)
@XmlEnum
public enum UserStatus {
    ACCEPTED,
    AWAITING_APPROVAL,
    BLOCKED,
    REMOVED
}
