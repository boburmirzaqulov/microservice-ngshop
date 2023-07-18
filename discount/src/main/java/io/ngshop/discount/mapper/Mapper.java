package io.ngshop.discount.mapper;

import io.ngshop.discount.dto.DiscountCreateDto;
import io.ngshop.discount.entitiy.DiscountEntity;

public class Mapper {
    public static DiscountDto toDto(DiscountEntity discount){
        return new DiscountDto(
                discount.getId(),
                discount.getProductName(),
                discount.getPercent(),
                discount.getDiscountProductId().getProductId()
                        );
    }
    public  static DiscountEntity tiEntity(DiscountCreateDto discountCreateDto){
        if(discountCreateDto==null) return null;
        return new DiscountEntity(
                discountCreateDto.getProductName(),
                discountCreateDto.getDescription(),
                discountCreateDto.getPercent()
        );
    }
}
