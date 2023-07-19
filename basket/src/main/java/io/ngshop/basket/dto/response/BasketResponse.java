package io.ngshop.basket.dto.response;


import io.ngshop.basket.dto.BasketDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasketResponse {
    private String UserName;
    private List<BasketDTO> Items;
    private Double totalPrice;
}
