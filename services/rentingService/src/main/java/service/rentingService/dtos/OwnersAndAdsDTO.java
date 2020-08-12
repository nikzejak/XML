package service.rentingService.dtos;

import service.rentingService.model.Ad;
import service.rentingService.model.Client;

import java.util.ArrayList;
import java.util.List;

public class OwnersAndAdsDTO {
    private List<AdRentDTO> ads;
    private Client client;

    public OwnersAndAdsDTO() {
        ads=new ArrayList<>();
    }

    public List<AdRentDTO> getAds() {
        return ads;
    }

    public void setAds(List<AdRentDTO> ads) {
        this.ads = ads;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "OwnersAndAdsDTO{" +
                "ads=" + ads +
                ", client=" + client +
                '}';
    }
}
