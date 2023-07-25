package io.ngshop.basket.dto.response;


import io.ngshop.basket.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasketResponse {
    private ObjectId objectId;
    private String userName;
    private List<ProductDTO> Items;
    private Double totalPrice;
}
