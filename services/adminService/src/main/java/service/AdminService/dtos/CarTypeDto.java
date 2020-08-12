package service.AdminService.dtos;

public class CarTypeDto {

    private String type;

    public CarTypeDto() {}

    public CarTypeDto(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
