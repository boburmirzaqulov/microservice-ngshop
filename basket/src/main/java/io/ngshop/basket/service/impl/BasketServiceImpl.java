package io.ngshop.basket.service.impl;

import io.ngshop.basket.clients.DiscountClient;
import io.ngshop.basket.clients.UserClient;
import io.ngshop.basket.config.RabbitMQConfig;
import io.ngshop.basket.customexception.FeinClientException;
import io.ngshop.basket.customexception.NoResourceFoundException;
import io.ngshop.basket.dto.*;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.mapper.BasketMapper;
import io.ngshop.basket.model.Basket;
import io.ngshop.basket.repository.BasketRepository;
import io.ngshop.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;
    private final DiscountClient discountClient;
    private final UserClient userClient;
    private final AmqpTemplate amqpTemplate;

    @Override
    public ResponseEntity<BasketResponse> getBasketByUsername(String username) {
        Basket basket = basketRepository.findByUserName(username)
                .orElseThrow(() -> new NoResourceFoundException("BASKET NOT FOUND"));
        BasketResponse basketResponse = basketMapper.toDtoRes(basket);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<BasketResponse> createBasket(BasketResponse basketResponse) {
        BasketDTO basketDTO = new BasketDTO(
                null,
                basketResponse.getUserName(),
                new ArrayList<>(basketResponse.getItems()),
                basketResponse.getTotalPrice()
        );
        try{
            List<ProductDTO> existProducts = new ArrayList<>();
            basketRepository.findByUserName(basketDTO.getUserName())
                            .ifPresent(basket -> {
                                basketDTO.setId(basket.getId());
                                existProducts.addAll(basket.getItems());
                            });

            basketDTO.getItems().forEach(productDTO -> {
                if(!existProducts.contains(productDTO)) {
                    DiscountDTO discount = discountClient.getProductByName(productDTO.getProductName());
                    productDTO.setPrice(productDTO.getPrice() - discount.getAmount());
                }
            });
        }catch(FeignException ex){
            if(ex.status()!= 400) throw new FeinClientException(ex.getMessage());
        }
        basketDTO.setTotalPrice(
                basketDTO.getItems().stream()
                        .mapToDouble(value -> value.getPrice()* value.getQuantity())
                        .sum()
        );
        Basket save = basketRepository.save(basketMapper.toEntity(basketDTO));
        return ResponseEntity.ok(basketMapper.toDtoRes(save));
    }

    @Override
    public ResponseEntity<BasketResponse> checkoutBasket(BasketResponse basketDTO){
        UserDto user = userClient.getUserByUsername(basketDTO.getUserName());
        RabbitMessage message = new RabbitMessage(
                user.getUsername(),
                basketDTO.getTotalPrice(),
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getAddress(),
                user.getCountry(),
                user.getState(),
                user.getZipCode(),
                user.getCardName(),
                user.getCardNumber(),
                user.getExpiration(),
                user.getCvv(),
                new ArrayList<>(basketDTO.getItems())
        );
        amqpTemplate.convertAndSend(RabbitMQConfig.exchange,RabbitMQConfig.routingKey,message);
        return ResponseEntity.ok(basketDTO);
    }

    @Override
    public ResponseEntity<Void> deleteBasket(String username) {
        Basket basket = basketRepository.findByUserName(username)
                .orElseThrow(() -> new NoResourceFoundException("Basket not found"));
        basketRepository.deleteById(basket.getId());
        return ResponseEntity.ok().build();
    }
}
