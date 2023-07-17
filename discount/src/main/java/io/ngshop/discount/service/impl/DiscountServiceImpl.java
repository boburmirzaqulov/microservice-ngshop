package io.ngshop.discount.service.impl;

import io.ngshop.discount.dto.DiscountDto;
import io.ngshop.discount.entitiy.Discount;
import io.ngshop.discount.mapper.DiscountMapper;
import io.ngshop.discount.repository.DiscountRepository;
import io.ngshop.discount.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;
    @Override
    public ResponseEntity<DiscountDto> getDiscountById(Long id) {
        Optional<Discount> discount = discountRepository.findById(id);
        return null;
    }


    @Override
    public ResponseEntity<List<DiscountDto>> getAllDiscount(Optional<Integer> offset, Optional<Integer> limit) {
        return null;
    }

    @Override
    public ResponseEntity<DiscountDto> saveDiscount(DiscountDto discountDto) {
        return null;
    }

    @Override
    public ResponseEntity<DiscountDto> updateDiscount(DiscountDto discountDto) {
        return null;
    }

    @Override
    public void deleteDiscount(Long id) {

    }
}
