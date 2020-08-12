package service.rentingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.rentingService.model.Ad;
import service.rentingService.model.Cart;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findAll();
    Cart findCartById(Long id);
    Cart findCartByAd(Ad ad);
}
