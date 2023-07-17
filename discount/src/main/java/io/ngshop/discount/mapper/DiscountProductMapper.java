package io.ngshop.discount.mapper;

import io.ngshop.discount.dto.DiscountProductDto;
import io.ngshop.discount.entitiy.DiscountProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountProductMapper {
    public DiscountProduct toEntity(DiscountProductDto discountProductDto){
        if(discountProductDto == null) return null;
        return new DiscountProduct(
                discountProductDto.id(),
                discountProductDto.discount()
        );
    }

    public DiscountProductDto toDto(DiscountProduct discountProduct){
        if(discountProduct == null) return null;
        return new DiscountProductDto(
                discountProduct.getId(),
                discountProduct.getDiscount()
        );
    }
}
