package io.ngshop.basket.service;

import io.ngshop.basket.dto.BasketV2DTO;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.model.Basket;
import org.springframework.http.ResponseEntity;

public interface BasketService {


    ResponseEntity<BasketResponse> getBasketByUsername(String username);

    ResponseEntity<BasketResponse> createBasket(BasketResponse basketResponse);

    ResponseEntity<BasketResponse> checkoutBasket(BasketResponse basketResponse);

    ResponseEntity<Void> deleteBasket(String username);
}
