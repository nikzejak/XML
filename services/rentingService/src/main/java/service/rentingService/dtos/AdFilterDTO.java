package service.rentingService.dtos;

public class AdFilterDTO {
    private String startDate;
    private String endDate;
    private String place;
    private Number id;

    public AdFilterDTO(String startDate, String endDate, String place, Number id) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AdFilterDTO{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", place='" + place + '\'' +
                ", id=" + id +
                '}';
    }
}
