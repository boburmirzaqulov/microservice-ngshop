package io.ngshop.catalog.controller;

import io.ngshop.catalog.groups.OnCreate;
import io.ngshop.catalog.groups.OnUpdate;
import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Type;
import io.ngshop.catalog.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class BrandController {
    private final BrandService brandService;

    @GetMapping("GetAllBrands")
    public ResponseEntity<List<Brand>> getAllBrands(){
        return brandService.findAll();
    }

    @PostMapping("CreateBrand")
    @Validated(OnCreate.class)
    public ResponseEntity<Brand> createBrand(@Valid @RequestBody Brand brand){
        return brandService.create(brand);
    }

    @PutMapping("UpdateBrand")
    @Validated(OnUpdate.class)
    public ResponseEntity<Brand> updateBrand(@Valid @RequestBody Brand brand){
//        return brandService.update(id,brand);
        return null;
    }
}
