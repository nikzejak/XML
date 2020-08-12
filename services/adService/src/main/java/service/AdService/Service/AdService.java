package service.AdService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdService.model.Ad;
import service.AdService.repository.AdRepo;

import java.util.List;

@Service
public class AdService {

    @Autowired
    AdRepo adRepo;

    public Ad findAdById(Long id) {
        return adRepo.findAdById(id);
    }
    public List<Ad> findAll() {
        return  adRepo.findAll();
    }
    public List<Ad> findAllByCliendId(Long id) {
        return  adRepo.findAllByClientId(id);
    }

    public Ad save(Ad c)
    {
        return  adRepo.save(c);
    }

    public boolean addAd(Ad c){

        List<Ad> tmp = findAll();
        if(tmp.size() == 0)
        {
            adRepo.save(c);
            return true;
        }
        for(Ad c1 : tmp)
            if(c1.getTitle().equals(c.getTitle()))
            {
                return  false;
            }
            else
            {
                adRepo.save(c);
                return true;
            }

        return false;

    }

    public Ad getAd(String title){
        List<Ad> tmp = findAll();
        if(tmp.size() == 0)
            return null;

        for(Ad c : tmp)
        {
            if(c.getTitle() == null)
                return null;
            if(c.getTitle().equals(title))
                return c;
        }

        return null;
    }
}
