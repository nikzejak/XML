package service.AdminService.dtos;

public class CarModelDto {
    private String model;

    public CarModelDto() {}

    public CarModelDto(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
