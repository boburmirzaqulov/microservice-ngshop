package io.ngshop.catalog.service;

import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Type;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandService {
    ResponseEntity<List<Brand>> findAll();
}
