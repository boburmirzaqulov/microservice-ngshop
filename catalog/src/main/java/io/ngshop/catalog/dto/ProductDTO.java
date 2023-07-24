package io.ngshop.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private Double price;
    private String summary;
    private String imageFile;
    private String brandId;
    private String typeId;
}
