package io.ngshop.discount.dto;

import io.ngshop.discount.model.Discount;

public record DiscountProductDto (
        Long id,
        Discount discount
) {
}
