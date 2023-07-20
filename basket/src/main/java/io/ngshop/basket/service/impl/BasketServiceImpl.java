package io.ngshop.basket.service.impl;

import io.ngshop.basket.clients.DiscountClient;
import io.ngshop.basket.customexception.NoResourceFoundException;
import io.ngshop.basket.dto.BasketV2DTO;
import io.ngshop.basket.dto.DiscountDTO;
import io.ngshop.basket.dto.ProductDTO;
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
    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;
    private final DiscountClient discountClient;

    @Override
    public ResponseEntity<BasketResponse> getBasketByUsername(String username) {
        Basket basket = basketRepository.findByUsername(username)
                .orElseThrow(() -> new NoResourceFoundException(" BASKET NOT FOUND "));
        BasketResponse basketResponse = basketMapper.toDto(basket);

        return ResponseEntity.ok(basketResponse);
    }

    @Override
    public ResponseEntity<BasketResponse> createBasket(BasketResponse basketResponse) {
        for (ProductDTO productDTO: basketResponse.getItems()) {
            String productName = productDTO.getProductName();
            DiscountDTO discountDTO = discountClient.getDiscount(productName);
            Double amount = discountDTO.getAmount();
            productDTO.setPrice(productDTO.getPrice()-amount);
        }

        Basket basket = basketMapper.toEntity(basketResponse);
        basket = basketRepository.save(basket);

        return ResponseEntity.ok(basketMapper.toDto(basket));
    }

    @Override
    public ResponseEntity<Basket> checkoutBasket(BasketV2DTO basketV2DTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteBasket(String username) {
        Basket basket = basketRepository.findByUsername(username)
                .orElseThrow(() -> new NoResourceFoundException("Basket not found"));
        basketRepository.deleteById(basket.getObjectId());
        return ResponseEntity.ok().build();
    }
}
