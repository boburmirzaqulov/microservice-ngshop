package io.ngshop.catalog.mapper;


import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.model.Product;
import org.springframework.stereotype.Service;


@Service
public class ProductMapper {
    public ProductDTO toDto(Product product){
        return product == null ? null : new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSummary(),
                product.getImageFile(),
                product.getBrandId()
        );
    }
    public Product toEntity(ProductDTO productDto){
        return productDto == null ? null : new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getSummary(),
                productDto.getImageFile(),
                productDto.getBrandId()
        );
    }
}