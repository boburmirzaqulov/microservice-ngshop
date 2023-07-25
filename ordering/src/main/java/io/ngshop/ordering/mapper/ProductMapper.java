package io.ngshop.ordering.mapper;

import io.ngshop.ordering.dto.ProductDTO;
import io.ngshop.ordering.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMapper {
    public Product toEntity(ProductDTO productDTO){
        return productDTO == null ? null : new Product(
                productDTO.getId(),
                productDTO.getQuantity(),
                productDTO.getImageFile(),
                productDTO.getPrice(),
                productDTO.getProductName()
        );
    }

    public ProductDTO toDto(Product product){
        return product == null ? null : new ProductDTO(
                product.getId(),
                product.getQuantity(),
                product.getImageFile(),
                product.getPrice(),
                product.getProductName()
        );
    }
}
