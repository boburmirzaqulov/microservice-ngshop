package io.ngshop.discount.mapper;

import io.ngshop.discount.dto.DiscountDto;
import io.ngshop.discount.model.Discount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountMapper {
    public Discount toEntity(DiscountDto discountDto){
        if(discountDto == null) return  null;
        return new Discount(
                discountDto.id(),
                discountDto.name()
        );
    }

    public DiscountDto toDto(Discount discount){
        if(discount == null) return null;
        return new DiscountDto(
                discount.getId(),
                discount.getName()
        );
    }
}
