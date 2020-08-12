package service.AdminService.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "", propOrder = {
        "id"
})
@XmlRootElement(name = "getCarBrandRequest", namespace = "http://ftn.uns.ac.rs.tim13")
public class GetCarBrandRequest {

    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
