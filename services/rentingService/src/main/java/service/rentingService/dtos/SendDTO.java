package service.rentingService.dtos;

public class SendDTO {
    AdRentDTO adWithTimes;
    String email;

    public SendDTO() {
    }

    public AdRentDTO getAdWithTimes() {
        return adWithTimes;
    }

    public void setAdWithTimes(AdRentDTO adWithTimes) {
        this.adWithTimes = adWithTimes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SendDTO{" +
                "adWithTimes=" + adWithTimes.toString() +
                ", email='" + email + '\'' +
                '}';
    }
}
