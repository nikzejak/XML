package service.AdminService.dtos;

public class CarBrandDto {
    private String brand;

    public CarBrandDto() {}

    public CarBrandDto(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
