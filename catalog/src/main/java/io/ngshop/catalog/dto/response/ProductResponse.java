package io.ngshop.catalog.dto.response;

import io.ngshop.catalog.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer count;
    private List<ProductDTO> data;

}
