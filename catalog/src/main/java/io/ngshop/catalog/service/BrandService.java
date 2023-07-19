package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.model.Brand;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandService {
    ResponseEntity<List<Brand>> findAll();
    ResponseEntity<BrandDto> create(BrandDto brand);
    ResponseEntity<BrandDto> update(String id,BrandDto brand);
    ResponseEntity<BrandDto> delete(String brandId);
}
