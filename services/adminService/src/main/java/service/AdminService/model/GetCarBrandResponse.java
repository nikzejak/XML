package service.AdminService.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "", propOrder = {
        "brand"
})
@XmlRootElement(name = "getCarBrandResponse", namespace = "http://ftn.uns.ac.rs.tim13")
public class GetCarBrandResponse {

    @XmlElement(namespace = "http://ftn.uns.ac.rs.tim13")
    protected CarBrand brand;

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }
}
