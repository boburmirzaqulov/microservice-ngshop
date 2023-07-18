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
        return ResponseEntity.ok(discountMapper.toDto(discount.get()));
    }


    @Override
    public ResponseEntity<List<DiscountDto>> getAllDiscount(Optional<Integer> offset, Optional<Integer> limit) {
        return null;
    }

    @Override
    public ResponseEntity<DiscountDto> saveDiscount(DiscountDto discountDto) {
        Discount discount = discountRepository.save(discountMapper.toEntity(discountDto));

        return ResponseEntity.ok(discountMapper.toDto(discount));
    }

    @Override
    public ResponseEntity<DiscountDto> updateDiscount(DiscountDto discountDto) {
        Optional<Discount> optionalDiscount = discountRepository.findById(discountDto.id());
        return ResponseEntity.ok(discountMapper
                .toDto(discountRepository
                        .save(discountMapper
                                .toEntity(discountDto))));
    }

    @Override
    public ResponseEntity<DiscountDto> deleteDiscount(Long id) {
        Optional<Discount> discountOptional = discountRepository.findById(id);
        discountRepository.delete(discountOptional.get());
        return ResponseEntity.ok(discountMapper.toDto(discountOptional.get()));

    }
}
