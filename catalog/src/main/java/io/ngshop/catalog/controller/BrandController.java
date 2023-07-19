package io.ngshop.catalog.controller;

import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Type;
import io.ngshop.catalog.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping("GetAllBrands")
    public ResponseEntity<List<Brand>> getAllBrands(){
        return brandService.findAll();
    }
}
