package io.ngshop.catalog.service.Impl;

import io.ngshop.catalog.dto.TypeDto;
import io.ngshop.catalog.exception.NotFoundException;
import io.ngshop.catalog.mapper.TypeMapper;
import io.ngshop.catalog.model.Type;
import io.ngshop.catalog.repository.TypeRepository;
import io.ngshop.catalog.service.CommonService;
import io.ngshop.catalog.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    @Override
    public ResponseEntity<List<TypeDto>> findAll() {
        List<Type> all = typeRepository.findAll();
        return ResponseEntity.ok(all.stream().map(typeMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<TypeDto> create(TypeDto typeDto) {
        Type entity = typeMapper.toEntity(typeDto);
        Type save = typeRepository.save(entity);
        return ResponseEntity.ok(typeMapper.toDto(save));
    }

    @Override
    public ResponseEntity<TypeDto> update(TypeDto typeDto) {
        Type type = typeRepository.findById(CommonService.checkObjectId(typeDto.getId())).orElseThrow(() -> new NotFoundException("Type not found"));
        type.setName(typeDto.getName());
        Type save = typeRepository.save(type);
        return ResponseEntity.ok(typeMapper.toDto(save));
    }
}
