package io.ngshop.discount.Service;

import io.ngshop.discount.CouponDto.CouponDto;
import io.ngshop.discount.model.Coupon;
import org.springframework.http.ResponseEntity;

public interface CouponService {

    ResponseEntity<CouponDto> getCouponByProductName(String productName);

    ResponseEntity<CouponDto> createCoupon(CouponDto couponDto);

    ResponseEntity<CouponDto> updateCoupon(CouponDto couponDto);

    ResponseEntity<CouponDto> deleteCoupon(String productName);

}
