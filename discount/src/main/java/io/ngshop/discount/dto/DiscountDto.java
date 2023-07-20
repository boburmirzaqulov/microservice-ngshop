package io.ngshop.discount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDto {
    private Long id;
    private String productName;
    private Double percent;
    private String Description;
}
