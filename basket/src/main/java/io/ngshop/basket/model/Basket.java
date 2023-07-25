package io.ngshop.basket.model;


import io.ngshop.basket.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Basket {
    @Id
    private ObjectId id;
    private String userName;
    private List<ProductDTO> items;
    private Double totalPrice;
}
