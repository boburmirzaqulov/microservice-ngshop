package io.ngshop.basket.mapper;

import io.ngshop.basket.clients.UserClient;
import io.ngshop.basket.dto.BasketCheckout;
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
                null,
                basketResponse.getUserName(),
                basketResponse.getItems(),
                basketResponse.getTotalPrice()
        );
    }

    public BasketResponse toDto(Basket basket){
        return new BasketResponse(
                basket.getUsername(),
                basket.getItems(),
                basket.getTotalPrice()
        );
    }


    public BasketCheckout toCheckout(BasketResponse basketResponse){
//        UserDTO userDTO = userClient.getUser(basketResponse.getUserName());
        UserDTO userDTO = new UserDTO();
        return new BasketCheckout(
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
    }

}
