package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.model.Brand;
import org.springframework.stereotype.Service;

@Service
public class BrandMapper {

    public BrandDto toDto(Brand brand) {
        if (brand == null) return null;
        return new BrandDto(
                brand.getId().toString(),
                brand.getName()
        );
    }

    public Brand toEntity(BrandDto brandDto) {
        return brandDto == null ? null : new Brand(
                null,
                brandDto.getName()
        );
    }


}
