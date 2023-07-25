package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.service.imp.CommonService;
import org.bson.types.ObjectId;
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
        if (brandDto == null) return null;
        ObjectId objectId = null;
        if (brandDto.getId() != null){
            objectId = CommonService.checkObjectId(brandDto.getId());
        }
        return new Brand(
                objectId,
                brandDto.getName()
        );
    }


}
