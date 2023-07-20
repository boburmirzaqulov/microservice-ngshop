package io.ngshop.basket.service.impl;

import io.ngshop.basket.dto.BasketV2DTO;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.dto.response.BasketRequest;
import io.ngshop.basket.model.Basket;
import io.ngshop.basket.repository.BasketRepository;
import io.ngshop.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {


    @Override
    public ResponseEntity<BasketResponse> getBasketByUsername(String username) {
        return null;
    }

    @Override
    public ResponseEntity<BasketRequest> createBasket(BasketRequest basketRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Basket> checkoutBasket(BasketV2DTO basketV2DTO) {
        return null;
    }
}
