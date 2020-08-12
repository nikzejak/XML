package service.rentingService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.rentingService.model.Ad;
import service.rentingService.model.Cart;
import service.rentingService.repository.CartRepo;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;

    public Cart findCartByAd(Ad ad) {
        return cartRepo.findCartByAd(ad);
    }

    public List<Cart> findAll(){return cartRepo.findAll();};

    public void addCart(Cart cart){
        cartRepo.save(cart);
    }

    public void deleteAll(){
        cartRepo.deleteAll();
    }
}
