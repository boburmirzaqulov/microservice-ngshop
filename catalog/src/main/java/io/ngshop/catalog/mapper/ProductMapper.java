package io.ngshop.catalog.mapper;


import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.service.CommonService;
import org.springframework.stereotype.Service;


@Service
public class ProductMapper {
    public ProductDTO toDto(Product product){
        return product == null ? null : new ProductDTO(
                product.getId() != null ? product.getId().toString() : null,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSummary(),
                product.getImageFile(),
                product.getBrandId() != null ? product.getBrandId().toString() : null,
                product.getTypeId() != null ? product.getTypeId().toString() : null
        );
    }
    public Product toEntity(ProductDTO productDto){
        return productDto == null ? null : new Product(
                null,
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getSummary(),
                productDto.getImageFile(),
                CommonService.checkObjectId(productDto.getBrandId()),
                CommonService.checkObjectId(productDto.getTypeId())
        );
    }
}
