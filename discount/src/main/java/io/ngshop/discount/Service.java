package io.ngshop.discount;

import org.springframework.http.ResponseEntity;

public interface Service {
    public ResponseEntity<DiscountDto> getByProductId(Long productId);

    ResponseEntity<DiscountDto> getDiscount(String slug);
    ResponseEntity<String> createDiscount(DiscountCreateDto discountCreateDto);

    ResponseEntity<String> deleteDiscount(String slug);

    ResponseEntity<DiscountDto> updateDiscount(String slug, DiscountDto discountDto);
}
