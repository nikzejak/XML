package service.AdminService.dtos;

public class FuelTypeDto {
    private String serialNumber;
    private String type;

    public FuelTypeDto(String type, String serialNumber) {
        this.type = type;
        this.serialNumber = serialNumber;
    }

    public FuelTypeDto() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
