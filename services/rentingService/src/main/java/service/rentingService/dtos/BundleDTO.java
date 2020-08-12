package service.rentingService.dtos;

import java.util.ArrayList;
import java.util.List;

public class BundleDTO {
    private List<AdRentDTO> adsWithTimes;

    public BundleDTO(List<AdRentDTO> adsWithTimes) {
        this.adsWithTimes = adsWithTimes;
    }

    public BundleDTO() {
        adsWithTimes = new ArrayList<>();
    }

    public List<AdRentDTO> getAdsWithTimes() {
        return adsWithTimes;
    }

    public void setAdsWithTimes(List<AdRentDTO> adsWithTimes) {
        this.adsWithTimes = adsWithTimes;
    }
}
