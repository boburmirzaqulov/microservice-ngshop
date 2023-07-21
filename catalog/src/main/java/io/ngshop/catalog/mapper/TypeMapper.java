package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.TypeDto;
import io.ngshop.catalog.model.Type;
import io.ngshop.catalog.service.imp.CommonService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class TypeMapper {
    public TypeDto toDto(Type type) {
        if (type == null) return null;
        CommonService.checkObjectId(String.valueOf(type.getId()));
        return new TypeDto(
                type.getId().toString(),
                type.getName()
        );
    }

    public Type toEntity(TypeDto typeDto) {
        if (typeDto == null) return null;
        ObjectId objectId = CommonService.checkObjectId(String.valueOf(typeDto.getId()));
        return new Type(
                objectId,
                typeDto.getName()
        );
    }
}
