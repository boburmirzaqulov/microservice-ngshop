package io.ngshop.discount.Service.CouponServiceImpl;

import io.ngshop.discount.CouponDto.CouponDto;
import io.ngshop.discount.Service.CouponService;
import io.ngshop.discount.customexeption.NoResourceFoundException;
import io.ngshop.discount.mapper.CouponMapper;
import io.ngshop.discount.model.Coupon;
import io.ngshop.discount.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;
    private final CouponMapper couponMapper;

    @Override
    public ResponseEntity<CouponDto> getCouponByProductName(String productName) {
        Coupon coupon = couponRepository.findByProductName(productName)
                .orElseThrow(()-> new NoResourceFoundException("discount not found"));
        return ResponseEntity.ok(couponMapper.toDto(coupon));
    }

    @Override
    public ResponseEntity<CouponDto> createCoupon(CouponDto couponDto) {
        Coupon coupon = couponRepository.save(couponMapper.toEntity(couponDto));
        return ResponseEntity.ok(couponMapper.toDto(coupon));
    }

    @Override
    public ResponseEntity<CouponDto> updateCoupon(CouponDto couponDto) {
        Coupon coupon = couponRepository.findByProductName(couponDto.getProductName())
                .orElseThrow(()-> new NoResourceFoundException("discount not found"));
        coupon.setDescription(couponDto.getDescription());
        coupon.setAmount(couponDto.getAmount());

        Coupon result = couponRepository.save(coupon);

        return ResponseEntity.ok(couponMapper.toDto(result));
    }

    @Override
    public ResponseEntity<CouponDto> deleteCoupon(String productName) {
        Coupon coupon = couponRepository.findByProductName(productName)
                .orElseThrow(()-> new NoResourceFoundException("discount not found"));
        couponRepository.delete(coupon);
        return ResponseEntity.ok(couponMapper.toDto(coupon));
    }

}
