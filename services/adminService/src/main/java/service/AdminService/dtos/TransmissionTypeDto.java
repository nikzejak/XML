package service.AdminService.dtos;

public class TransmissionTypeDto {
    private String serialNumber;
    private String type;



    public TransmissionTypeDto() {
    }

    public TransmissionTypeDto(String serialNumber,String type) {
        this.serialNumber = serialNumber;
        this.type = type;


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
