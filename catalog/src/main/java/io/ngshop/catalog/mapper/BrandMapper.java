package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.exception.WrongObjectIdException;
import io.ngshop.catalog.model.Brand;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class BrandMapper {

    public BrandDto toDto(Brand brand) {
        if (brand == null) return null;
        if (brand.getId().toString().length() != 24) throw new WrongObjectIdException("Wrong Brand id");

        return new BrandDto(
                brand.getId().toString(),
                brand.getName()
        );
    }

    public Brand toEntity(BrandDto brandDto) {
        if (brandDto == null) return null;
        if (brandDto.getId().length() != 24) throw new WrongObjectIdException("Wrong Brand id");

        return new Brand(
                new ObjectId(brandDto.getId()),
                brandDto.getName()
        );
    }
}
