package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.BrandDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandService {
    ResponseEntity<List<BrandDTO>> findAll();
    ResponseEntity<BrandDTO> create(BrandDTO brand);
    ResponseEntity<BrandDTO> update(String id, BrandDTO brand);
    ResponseEntity<BrandDTO> delete(String brandId);
}
