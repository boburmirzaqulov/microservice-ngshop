package io.ngshop.basket.service.impl;

import io.ngshop.basket.dto.BasketDTO;
import io.ngshop.basket.dto.BasketV2DTO;
import io.ngshop.basket.dto.response.BasketRequest;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.mapper.BasketMapper;
import io.ngshop.basket.model.Basket;
import io.ngshop.basket.repository.BasketRepository;
import io.ngshop.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketMapper basketMapper;
    private final BasketRepository basketRepository;

    @Override
    public ResponseEntity<BasketResponse> getBasketByUsername(String username) {
        return null;
    }

    @Override
    public ResponseEntity<BasketDTO> createBasket(BasketDTO basketDTO) {
        Basket save = basketRepository.save(basketMapper.toEntity(basketDTO));
        return ResponseEntity.ok(basketMapper.toDto(save));
    }

    @Override
    public ResponseEntity<Basket> checkoutBasket(BasketV2DTO basketV2DTO) {
        return null;
    }
}
