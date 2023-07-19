package io.ngshop.catalog.service.impl;

import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Type;
import io.ngshop.catalog.repository.BrandRepository;
import io.ngshop.catalog.repository.TypeRepository;
import io.ngshop.catalog.service.BrandService;
import io.ngshop.catalog.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    @Override
    public ResponseEntity<List<Type>> findAll() {
        return ResponseEntity.ok(typeRepository.findAll());
    }
}
