package io.ngshop.ordering.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull(message = "Id do not null!")
    @NotEmpty(message = "Id do not empty!")
    private String Id;
    @NotNull(message = "quantity do not null!")
    @NotEmpty(message = "quantity do not empty!")
    private Integer quantity;
    @NotNull(message = "imageFile do not null!")
    @NotEmpty(message = "imageFile do not empty!")
    private String imageFile;
    @NotNull(message = "price do not null!")
    @NotEmpty(message = "price do not empty!")
    private Double price;
    @NotNull(message = "productName do not null!")
    @NotEmpty(message = "productName do not empty!")
    private String productName;
}
