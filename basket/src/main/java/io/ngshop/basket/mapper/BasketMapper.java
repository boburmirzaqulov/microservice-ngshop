package io.ngshop.basket.mapper;

import io.ngshop.basket.clients.UserClient;
import io.ngshop.basket.dto.UserDTO;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.model.Basket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketMapper {

    private final UserClient userClient;

    public Basket toEntity(BasketResponse basketResponse){
        return new Basket(
                basketResponse.getObjectId(),
                basketResponse.getUserName(),
                basketResponse.getItems(),
                basketResponse.getTotalPrice()
        );
    }
    public BasketResponse toDto(Basket basket){
        return new BasketResponse(
                basket.getObjectId(),
                basket.getUsername(),
                basket.getItems(),
                basket.getTotalPrice()
        );
    }






}
