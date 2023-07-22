package io.ngshop.basket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDto {
    private Long id;
    private String productName;
    private String description;
    private Double amount;
}
