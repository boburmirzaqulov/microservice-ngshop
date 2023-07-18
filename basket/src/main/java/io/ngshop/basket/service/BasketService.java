package io.ngshop.basket.service;

import io.ngshop.basket.Entity.BasketDTO;
import org.springframework.http.ResponseEntity;

public interface BasketService {

    ResponseEntity<BasketDTO> getBasket(String userName);

    ResponseEntity<BasketDTO> setBasket(BasketDTO basketDTO);

    ResponseEntity<BasketDTO> checkoutBasket(BasketDTO basketDTO);

    void deleteBasket(String userName);

    void createBasket(BasketDTO basketDTO);
}
