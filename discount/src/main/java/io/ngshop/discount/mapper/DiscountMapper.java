package io.ngshop.discount.mapper;


import io.ngshop.discount.dto.DiscountDto;
import io.ngshop.discount.model.Discount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscountMapper {
    DiscountDto toDto(Discount discount);
    Discount toEntity(DiscountDto discount);

}
