package io.ngshop.basket.mapper;

import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.model.Basket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasketMapper {
    private final UserClient userClient;


    public Basket toEntity(BasketDTO basketDTO){
        if(basketDTO == null) return null;
        return new Basket(
                basketDTO.getId(),
                basketDTO.getUserName(),
                basketDTO.getItems(),
                basketDTO.getTotalPrice()
        );
    }
    public BasketDTO toDto(Basket basket){
        if(basket == null) return null;
        return new BasketDTO(
                basket.getId(),
                basket.getUserName(),
                basket.getItems(),
                basket.getTotalPrice()
        );
    }

    public BasketResponse toDtoRes(Basket basket){
        if (basket == null) return null;
        return new BasketResponse(
                basket.getUserName(),
                new HashSet<>(basket.getItems()),
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
