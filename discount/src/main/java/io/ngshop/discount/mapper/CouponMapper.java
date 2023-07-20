package io.ngshop.discount.mapper;

import io.ngshop.discount.dto.CouponDto;
import io.ngshop.discount.model.Coupon;
import org.springframework.stereotype.Service;

@Service
public class CouponMapper {
    public Coupon toEntity(CouponDto couponDto){
        return new Coupon(
                couponDto.getId(),
                couponDto.getProductName(),
                couponDto.getDescription(),
                couponDto.getAmount()
        );
    };
    public CouponDto toDto(Coupon coupon){
        return new CouponDto(
                coupon.getId(),
                coupon.getProductName(),
                coupon.getDescription(),
                coupon.getAmount()
        );
    };
}
