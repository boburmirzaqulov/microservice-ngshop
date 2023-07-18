package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.model.Brand;
import org.springframework.stereotype.Service;

@Service
public class BrandMapper {
    public BrandDto toDto(Brand brand){
        return brand == null ? null : new BrandDto(
                brand.getId(),
                brand.getName()
        );
    }
    public Brand toEntity(BrandDto brandDto){
        return brandDto == null ? null : new Brand(
                brandDto.getId(),
                brandDto.getName()
        );
    }
}
