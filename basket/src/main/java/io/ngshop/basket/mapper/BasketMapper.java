package io.ngshop.basket.mapper;

import io.ngshop.basket.dto.BasketDTO;
import io.ngshop.basket.dto.ProductDTO;
import io.ngshop.basket.dto.response.BasketResponse;
import io.ngshop.basket.model.Basket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasketMapper {

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



}
