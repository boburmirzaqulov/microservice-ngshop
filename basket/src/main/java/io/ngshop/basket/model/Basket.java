package io.ngshop.basket.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Basket {
    private String username;
    private String ProductId;
    private Integer quantity;
    private String imageFile;
    private Double price;
    private String productName;

}
