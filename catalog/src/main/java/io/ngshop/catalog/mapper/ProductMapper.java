package io.ngshop.catalog.mapper;


import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.model.Product;
import org.springframework.stereotype.Service;


@Service
public class ProductMapper {
    public ProductDto toDto(Product product){
        return product == null ? null : new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSummary(),
                product.getImageFile()
        );
    }
    public Product toEntity(ProductDto productDto){
        return productDto == null ? null : new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getSummary(),
                productDto.getImageFile()
        );
    }
}