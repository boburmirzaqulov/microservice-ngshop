package io.ngshop.ordering.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer quantity;
    private String imageFile;
    private Double price;
    private String id;
    private String productName;
}
