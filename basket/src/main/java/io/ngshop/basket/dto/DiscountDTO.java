package io.ngshop.basket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiscountDTO {
    private Long id;
    private String productName;
    private String description;
    private Double amount;
}
