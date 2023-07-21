package io.ngshop.basket.service;

import io.ngshop.basket.dto.BasketDTO;
import io.ngshop.basket.dto.BasketV2DTO;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.dto.response.BasketRequest;
import io.ngshop.basket.model.Basket;
import org.springframework.http.ResponseEntity;

public interface BasketService {


    ResponseEntity<BasketResponse> getBasketByUsername(String username);

    ResponseEntity<BasketDTO> createBasket(BasketDTO basketDTO);

    ResponseEntity<Basket> checkoutBasket(BasketV2DTO basketV2DTO);
}
