package io.ngshop.basket.service.impl;

import feign.FeignException;
import io.ngshop.basket.clients.DiscountClient;
import io.ngshop.basket.clients.UserClient;
import io.ngshop.basket.config.RabbitMQConfig;
import io.ngshop.basket.customexception.FeinClientException;
import io.ngshop.basket.customexception.NoResourceFoundException;
import io.ngshop.basket.dto.*;
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
    private final BasketMapper basketMapper;
    private final BasketRepository basketRepository;
    private  final DiscountClient discountClient;
    private final UserClient userClient;
    private final AmqpTemplate amqpTemplate;

    @Override
    public ResponseEntity<BasketDTO> getBasketByUsername(String username) {
        Basket basket = basketRepository.findByUserName(username)
                .orElseThrow(() -> new NoResourceFoundException(" Basket not found"));
        return ResponseEntity.ok(basketMapper.toDto(basket));
    }

    @Override
    public ResponseEntity<BasketDTO> createBasket(BasketDTO basketDTO) {
        try{
            List<ProductDTO> existProducts = new ArrayList<>();
            basketRepository.findByUserName(basketDTO.getUserName())
                            .ifPresent(basket -> {
                                basketDTO.setId(basket.getId());
                                existProducts.addAll(basket.getItems());
                            });

            basketDTO.getItems().forEach(productDTO -> {
                if(!existProducts.contains(productDTO)) {
                    DiscountDto discount = discountClient.getProductByName(productDTO.getProductName());
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
        return ResponseEntity.ok(basketMapper.toDto(save));
    }

    @Override
    public ResponseEntity<BasketDTO> checkoutBasket(BasketDTO basketDTO){
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
                basketDTO.getItems()
        );
        amqpTemplate.convertAndSend(RabbitMQConfig.exchange,RabbitMQConfig.routingKey,message);
        return ResponseEntity.ok(basketDTO);
    }
}
