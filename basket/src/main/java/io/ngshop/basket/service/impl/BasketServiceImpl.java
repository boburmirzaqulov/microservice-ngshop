package io.ngshop.basket.service.impl;

import feign.FeignException;
import io.ngshop.basket.clients.DiscountClient;
import io.ngshop.basket.customexception.NoResourceFoundException;
import io.ngshop.basket.dto.BasketDTO;
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

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;
    private final DiscountClient discountClient;

    @Override
    public ResponseEntity<BasketResponse> getBasketByUsername(String username) {
        Basket basket = basketRepository.findByUserName(username)
                .orElseThrow(() -> new NoResourceFoundException("BASKET NOT FOUND"));
        BasketResponse basketResponse = basketMapper.toDtoRes(basket);

        return ResponseEntity.ok(basketResponse);
    }

    @Override
    public ResponseEntity<BasketResponse> createBasket(BasketResponse basketResponse) {
        try{
            BasketDTO basketDTO = new BasketDTO(
                    null,
                    basketResponse.getUserName(),
                    new ArrayList<>(basketResponse.getItems()),
                    basketResponse.getTotalPrice()
            );
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

    @Override
    public ResponseEntity<Void> deleteBasket(String username) {
        Basket basket = basketRepository.findByUsername(username)
                .orElseThrow(() -> new NoResourceFoundException("Basket not found"));
        basketRepository.deleteById(basket.getObjectId());
        return ResponseEntity.ok().build();
    }
}
