package io.ngshop.catalog.mapper;


import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.service.impl.CommonService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;


@Service
public class ProductMapper {
    public ProductDTO toDto(Product product){
        return product == null ? null : new ProductDTO(
                product.getId().toString(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSummary(),
                product.getImageFile(),
                product.getBrandId().toString(),
                product.getTypeId().toString()
        );
    }
    public Product toEntity(ProductDTO productDto){
        if (productDto == null) return null;

        ObjectId objectId = null;
        if(productDto.getId() != null){
            objectId = CommonService.checkObjectId(productDto.getId());
        }
        return new Product(
                objectId,
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getSummary(),
                productDto.getImageFile(),
                new ObjectId(productDto.getBrandId()),
                new ObjectId(productDto.getTypeId())
        );
    }
}
