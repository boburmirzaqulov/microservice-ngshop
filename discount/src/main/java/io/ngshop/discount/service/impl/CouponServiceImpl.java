package io.ngshop.discount.service.impl;

import io.ngshop.discount.customexseption.NoResourceFoundException;
import io.ngshop.discount.dto.CouponDto;
import io.ngshop.discount.mapper.CouponMapper;
import io.ngshop.discount.model.Coupon;
import io.ngshop.discount.repository.CouponRepository;
import io.ngshop.discount.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;
    private final CouponMapper couponMapper;
    @Override
    public ResponseEntity<CouponDto> getCouponByProductName(String productName) {

        Coupon discount = couponRepository.findByProductName(productName)
                .orElseThrow(() -> new NoResourceFoundException("discount not found"));

        return ResponseEntity.ok(couponMapper.toDto(discount));
    }

    @Override
    public ResponseEntity<CouponDto> createCoupon(CouponDto couponDto) {
        Coupon save = couponRepository.save(couponMapper.toEntity(couponDto));
        return ResponseEntity.ok(couponMapper.toDto(save));
    }

    @Override
    public ResponseEntity<CouponDto> updateCoupon(CouponDto couponDto) {
        Coupon coupon = couponRepository.findByProductName(couponDto.getProductName())
                .orElseThrow(() -> new NoResourceFoundException("discount not  found"));
        coupon.setDescription(couponDto.getDescription());
        coupon.setAmount(couponDto.getAmount());

        Coupon update = couponRepository.save(coupon);
        return ResponseEntity.ok(couponMapper.toDto(update));
    }

    @Override
    public ResponseEntity<CouponDto> deleteCoupon(String productName) {
        Coupon coupon = couponRepository.findByProductName(productName)
                .orElseThrow(() -> new NoResourceFoundException(" discount not found "));
        couponRepository.delete(coupon);
        return ResponseEntity.ok(couponMapper.toDto(coupon));
    }
}
