package io.ngshop.ordering.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotBlank(message = "Id is mandatory")
    private String id;
    @NotBlank(message = "Quantity is mandatory")
    private Integer quantity;
    @NotBlank(message = "Image file is mandatory")
    private String imageFile;
    @NotBlank(message = "Price is mandatory")
    private Double price;
    @NotBlank(message = "Product name is mandatory")
    private String productName;
}
