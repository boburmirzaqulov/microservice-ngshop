package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.BrandDTO;
import io.ngshop.catalog.groups.OnCreate;
import io.ngshop.catalog.groups.OnUpdate;
import io.ngshop.catalog.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
public class BrandController {
    private final BrandService brandService;

    @PostMapping("CreateBrand")
    @Validated(OnCreate.class)
    public ResponseEntity<BrandDTO> createBrand(@Valid @RequestBody BrandDTO brand){
        return brandService.create(brand);
    }

    @PutMapping("/UpdateBrand/{brandId}")
    @Validated(OnUpdate.class)
    public ResponseEntity<BrandDTO> updateBrand(@Valid @RequestBody BrandDTO brand, @PathVariable String brandId){
        return brandService.update(brandId,brand);
    }

    @DeleteMapping("/DeleteBrand/{brandId}")
    public ResponseEntity<BrandDTO> deleteBrand(@PathVariable String brandId){
        return brandService.delete(brandId);
    }
}