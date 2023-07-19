package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.TypeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeService {
    ResponseEntity<List<TypeDto>> findAll();
    ResponseEntity<TypeDto> create(TypeDto typeDto);
    ResponseEntity<TypeDto> update(TypeDto typeDto);
}
