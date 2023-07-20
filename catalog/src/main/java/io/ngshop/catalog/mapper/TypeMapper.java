package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.TypeDto;
import io.ngshop.catalog.model.Type;
import org.springframework.stereotype.Service;

@Service
public class TypeMapper {
    public TypeDto toDto(Type type){
        return type == null ? null : new TypeDto(
                type.getId().toString(),
                type.getName()
        );
    }
    public Type toEntity(TypeDto typeDto){
        return typeDto == null ? null : new Type(
                null,
                typeDto.getName()
        );
    }
}
