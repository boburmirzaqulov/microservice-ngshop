package io.ngshop.basket.dto.response;


import io.ngshop.basket.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasketResponse {
    private String userName;
    private Set<ProductDTO> Items;
    private Double totalPrice;
}
