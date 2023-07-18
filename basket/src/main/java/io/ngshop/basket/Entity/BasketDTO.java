package io.ngshop.basket.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketDTO {

    private String ProductId;
    private Integer quantity;
    private String imageFile;
    private Double price;
    private String productName;
}
