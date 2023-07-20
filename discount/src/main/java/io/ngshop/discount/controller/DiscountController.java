package io.ngshop.discount.controller;


import io.ngshop.discount.CouponDto.CouponDto;
import io.ngshop.discount.model.Coupon;
import io.ngshop.discount.Service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Discount")
@RequiredArgsConstructor
public class DiscountController {
    private final CouponService couponService;

    @GetMapping("/{productName}")
    public ResponseEntity<CouponDto> getCoupon(@PathVariable String productName){
        return couponService.getCouponByProductName(productName);
    }

    @PostMapping()
    public ResponseEntity<CouponDto> createCoupon(@RequestBody CouponDto couponDto){
        return couponService.createCoupon(couponDto);
    }
    @PutMapping()
    public ResponseEntity<CouponDto> updateCoupon(@RequestBody CouponDto couponDto){
        return couponService.updateCoupon(couponDto);
    }

    @DeleteMapping("/{productName}")
    public ResponseEntity<CouponDto> deleteCoupon(@PathVariable String productName){
        return couponService.deleteCoupon(productName);
    }
}
