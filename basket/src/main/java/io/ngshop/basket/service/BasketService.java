package io.ngshop.basket.service;

import feign.FeignException;
import io.ngshop.basket.dto.BasketV2DTO;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.model.Basket;
import org.springframework.http.ResponseEntity;

public interface BasketService {


    ResponseEntity<BasketResponse> getBasketByUsername(String username);

    ResponseEntity<BasketResponse> createBasket(BasketResponse basketResponse) throws FeignException;

    ResponseEntity<Basket> checkoutBasket(BasketV2DTO basketV2DTO);

    ResponseEntity<Void> deleteBasket(String username);
}
