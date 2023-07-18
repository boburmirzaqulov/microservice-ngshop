package io.ngshop.discount.service;

import io.ngshop.discount.dto.DiscountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface DiscountService {
    ResponseEntity<DiscountDto> getDiscountById(Long id);

    ResponseEntity<List<DiscountDto>> getAllDiscount(Optional<Integer> offset, Optional<Integer> limit);

    ResponseEntity<DiscountDto> saveDiscount(DiscountDto discountDto);

    ResponseEntity<DiscountDto> updateDiscount(DiscountDto discountDto);

    ResponseEntity<DiscountDto> deleteDiscount(Long id);
}
