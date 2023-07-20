package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.TypeDTO;
import io.ngshop.catalog.model.Type;
import org.springframework.stereotype.Service;

@Service
public class TypeMapper {
    public TypeDTO toDto(Type type) {
        return type == null ? null : new TypeDTO(
                type.getId().toString(),
                type.getName()
        );
    }

    public Type toEntity(TypeDTO typeDto) {
        return typeDto == null ? null : new Type(
                null,
                typeDto.getName()
        );
    }
}
