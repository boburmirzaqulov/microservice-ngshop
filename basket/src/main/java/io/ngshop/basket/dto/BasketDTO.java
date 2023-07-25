package io.ngshop.basket.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketDTO {
    private ObjectId id;
    private String userName;
    private List<ProductDTO> items;
    private Double totalPrice;

}
