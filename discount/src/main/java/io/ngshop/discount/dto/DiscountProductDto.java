package io.ngshop.discount.dto;

import io.ngshop.discount.entitiy.Discount;

public record DiscountProductDto (
        Long id,
        Discount discount
) {
}
