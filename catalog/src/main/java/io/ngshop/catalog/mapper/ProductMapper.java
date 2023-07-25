package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.model.Type;
import io.ngshop.catalog.repository.BrandRepository;
import io.ngshop.catalog.repository.TypeRepository;
import io.ngshop.catalog.service.impl.CommonService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductMapper {
    private final BrandRepository brandRepository;
    private final TypeRepository typeRepository;


    public ProductDTO toDto(Product product) {
        return product == null ? null : new ProductDTO(
                product.getId() != null ? product.getId().toString() : null,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSummary(),
                product.getImageFile(),
                Optional.ofNullable(product.getBrandId())
                        .flatMap(brandRepository::findById)
                        .orElse(new Brand(new ObjectId(), "unknown")).getName(),
                Optional.ofNullable(product.getTypeId())
                        .flatMap(typeRepository::findById)
                        .orElse(new Type(new ObjectId(), "unknown")).getName()
        );
    }

    public Product toEntity(ProductDTO productDto) {
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
