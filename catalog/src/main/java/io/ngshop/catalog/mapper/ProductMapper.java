package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductDTO productDTO){
        return new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getSummary(),
                productDTO.getImageFile(),
                productDTO.getBrandId()
        );
    }
    public ProductDTO toDto(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSummary(),
                product.getImageFile(),
                product.getBrandId()
        );
    }

}
