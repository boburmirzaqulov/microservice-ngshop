package io.ngshop.discount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto {
    private Long id;
    private String productName;
    private String description;
    private Double amount;
}
