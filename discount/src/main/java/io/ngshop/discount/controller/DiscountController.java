package io.ngshop.discount.controller;

import io.ngshop.discount.dto.CouponDto;
import io.ngshop.discount.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Discount")
@RequiredArgsConstructor
@CrossOrigin
public class DiscountController {
    private final CouponService couponService;
    @GetMapping("/{productName}")
    public ResponseEntity<CouponDto> getDiscountByProduct(@PathVariable String productName){
        return ResponseEntity.ok(new CouponDto(1L, productName, "some desc", 100.1));
//        return couponService.getCouponByProductName(productName);
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
