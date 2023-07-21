package io.ngshop.basket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String productId;
    private Integer quantity;
    private String imageFile;
    private Double price;
    private String productName;
}
