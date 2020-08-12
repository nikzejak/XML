package service.AdService.dto;

import service.AdService.model.*;

import java.util.Date;
import java.util.Set;

public class AdDTO {

    private String title;
    private String profilePicture;
    private String description;
    private String place;
    private Car car;
    private Client client;
    private String startOfAd;
    private String endOfAd;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getStartOfAd() {
        return startOfAd;
    }

    public void setStartOfAd(String startOfAd) {
        this.startOfAd = startOfAd;
    }

    public String getEndOfAd() {
        return endOfAd;
    }

    public void setEndOfAd(String endOfAd) {
        this.endOfAd = endOfAd;
    }

    @Override
    public String toString() {
        return "AdDTO{" +
                "title='" + title + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", description='" + description + '\'' +
                ", place='" + place + '\'' +
                ", car=" + car +
                ", client=" + client +
                ", startOfAd='" + startOfAd + '\'' +
                ", endOfAd='" + endOfAd + '\'' +
                '}';
    }
}

