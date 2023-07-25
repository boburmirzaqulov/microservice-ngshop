package io.ngshop.basket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer count;
    private List<ProductDTO> data;
}
