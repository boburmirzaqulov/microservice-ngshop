package io.ngshop.discount.service;

import io.ngshop.discount.dto.CouponDto;
import org.springframework.http.ResponseEntity;

public interface CouponService {
    ResponseEntity<CouponDto> getCouponByProductName(String productName);

    ResponseEntity<CouponDto> createCoupon(CouponDto couponDto);

    ResponseEntity<CouponDto> updateCoupon(CouponDto couponDto);

    ResponseEntity<CouponDto> deleteCoupon(String productName);
}
