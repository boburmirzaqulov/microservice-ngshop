package io.ngshop.basket.service;

import io.ngshop.basket.dto.BasketDTO;
import org.springframework.http.ResponseEntity;

public interface BasketService {


    ResponseEntity<BasketDTO> getBasketByUsername(String username);

    ResponseEntity<BasketDTO> createBasket(BasketDTO basketDTO);

    ResponseEntity<BasketDTO> checkoutBasket(BasketDTO basketDTO);
}
