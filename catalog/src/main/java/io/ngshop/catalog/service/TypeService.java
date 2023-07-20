package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.TypeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeService {
    ResponseEntity<List<TypeDTO>> findAll();
    ResponseEntity<TypeDTO> create(TypeDTO typeDto);
    ResponseEntity<TypeDTO> update(TypeDTO typeDto);
}
