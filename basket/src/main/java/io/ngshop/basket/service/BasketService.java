package io.ngshop.basket.service;

import io.ngshop.basket.dto.response.BasketResponse;
import org.springframework.http.ResponseEntity;

public interface BasketService {


    ResponseEntity<BasketResponse> getBasketByUsername(String username);

    ResponseEntity<BasketResponse> createBasket(BasketResponse basketResponse);

    ResponseEntity<BasketResponse> checkoutBasket(BasketResponse basketV2DTO);

    ResponseEntity<Void> deleteBasket(String username);
}
