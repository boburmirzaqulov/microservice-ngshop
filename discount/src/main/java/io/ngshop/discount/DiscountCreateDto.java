package io.ngshop.discount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCreateDto {
    private String productName;
    private Double percent;
    private String Description;
}
