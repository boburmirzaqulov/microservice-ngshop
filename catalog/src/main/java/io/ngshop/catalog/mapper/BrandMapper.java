package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.BrandDTO;
import io.ngshop.catalog.model.Brand;
import org.springframework.stereotype.Service;

@Service
public class BrandMapper {

    public BrandDTO toDto(Brand brand) {
        if (brand == null) return null;
        return new BrandDTO(
                brand.getId().toString(),
                brand.getName()
        );
    }

    public Brand toEntity(BrandDTO brandDto) {
        return brandDto == null ? null : new Brand(
                null,
                brandDto.getName()
        );
    }


}
