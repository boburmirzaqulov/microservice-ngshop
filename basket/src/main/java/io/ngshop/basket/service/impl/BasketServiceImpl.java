package io.ngshop.basket.service.impl;

import io.ngshop.basket.clients.DiscountClient;
import io.ngshop.basket.clients.UserClient;
import io.ngshop.basket.config.Config;
import io.ngshop.basket.customexception.NoResourceFoundException;
import io.ngshop.basket.dto.DiscountDTO;
import io.ngshop.basket.dto.ProductDTO;
import io.ngshop.basket.dto.RabbitMessage;
import io.ngshop.basket.dto.UserDTO;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.mapper.BasketMapper;
import io.ngshop.basket.model.Basket;
import io.ngshop.basket.repository.BasketRepository;
import io.ngshop.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;
    private final DiscountClient discountClient;
    private final AmqpTemplate amqpTemplate;
    private final UserClient userClient;

    @Override
    public ResponseEntity<BasketResponse> getBasketByUsername(String username) {
        Basket basket = basketRepository.findByUsername(username)
                .orElseThrow(() -> new NoResourceFoundException(" BASKET NOT FOUND "));
        BasketResponse basketResponse = basketMapper.toDto(basket);

        return ResponseEntity.ok(basketResponse);
    }

    @Override
    public ResponseEntity<BasketResponse> createBasket(BasketResponse basketResponse) {
        Basket finalBasket;
        Optional<Basket> existingBasket = basketRepository.findByUsername(basketResponse.getUserName());
        if (existingBasket.isPresent()) {
            Set<ProductDTO> existingItems = existingBasket.get().getItems();
            for (ProductDTO productDTO : basketResponse.getItems()) {
                if (!existingItems.contains(productDTO)) {
                    String productName = productDTO.getProductName();
                    DiscountDTO discountDTO = discountClient.getDiscount(productName);
                    Double amount = discountDTO.getAmount();
                    productDTO.setPrice(productDTO.getPrice() - amount);
                } else {
                    existingItems.remove(productDTO);
                }
            }
            existingBasket.get().getItems().addAll(basketResponse.getItems());
            finalBasket = existingBasket.get();
        } else {
            for (ProductDTO productDTO : basketResponse.getItems()) {
                String productName = productDTO.getProductName();
                DiscountDTO discountDTO = discountClient.getDiscount(productName);
                Double amount = discountDTO.getAmount();
                productDTO.setPrice(productDTO.getPrice() - amount);
            }
            finalBasket = basketMapper.toEntity(basketResponse);
        }

        Basket save = basketRepository.save(finalBasket);
        return ResponseEntity.ok(basketMapper.toDto(save));
    }

    @Override
    public ResponseEntity<BasketResponse> checkoutBasket(BasketResponse basketResponse) {
       // UserDTO userDTO = userClient.getUser(basketResponse.getUserName());
        UserDTO userDTO = new UserDTO(
                1L,
                "Ali",
                "Aliyev",
                "Alf",
                "aliali@gmail.com",
                "Toshkent",
                "Uzbekiston",
                "Juma",
                "29393993939",
                "Visa",
                "2828282828288228",
                "expiration",
                "cvv"
        );
        RabbitMessage message = new RabbitMessage(
                userDTO.getUsername(),
                basketResponse.getTotalPrice(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getAddress(),
                userDTO.getCountry(),
                userDTO.getState(),
                userDTO.getZipCode(),
                userDTO.getCardName(),
                userDTO.getCardNumber(),
                userDTO.getExpiration(),
                userDTO.getCvv(),
                basketResponse.getItems()
        );
        amqpTemplate.convertAndSend(Config.exchange,Config.routingKey,message);

        return ResponseEntity.ok(basketResponse);
    }

    @Override
    public ResponseEntity<Void> deleteBasket(String username) {
        Basket basket = basketRepository.findByUsername(username)
                .orElseThrow(() -> new NoResourceFoundException("Basket not found"));
        basketRepository.deleteById(basket.getObjectId());
        return ResponseEntity.ok().build();
    }
}
