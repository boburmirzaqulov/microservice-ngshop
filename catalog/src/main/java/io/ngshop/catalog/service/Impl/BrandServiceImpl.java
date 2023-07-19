package io.ngshop.catalog.service.impl;

import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.repository.BrandRepository;
import io.ngshop.catalog.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public ResponseEntity<List<Brand>> findAll() {
        return ResponseEntity.ok(brandRepository.findAll());
    }

    @Override
    public ResponseEntity<Brand> create(Brand brand) {
        return ResponseEntity.ok(brandRepository.save(brand));
    }

    @Override
    public ResponseEntity<Brand> update(String id, Brand brand) {
        return null;
    }
}
