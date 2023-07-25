package io.ngshop.catalog.controller;


import io.ngshop.catalog.dto.BrandDTO;
import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.dto.TypeDTO;
import io.ngshop.catalog.dto.response.ProductResponse;
import io.ngshop.catalog.groups.OnCreate;
import io.ngshop.catalog.groups.OnUpdate;
import io.ngshop.catalog.service.BrandService;
import io.ngshop.catalog.service.ProductService;
import io.ngshop.catalog.service.TypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final ProductService productService;
    private final TypeService typeService;
    private final BrandService brandService;


    @GetMapping("/test")
    public String working() {
        return "Hello World";
    }

    @GetMapping("/GetAllBrands")
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        return brandService.findAll();
    }

    @GetMapping("/GetAllTypes")
    public ResponseEntity<List<TypeDTO>> getAllTypes() {
        return typeService.findAll();
    }

    @GetMapping("/GetProductById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }


    @GetMapping("/GetProductByProductName/{productName}")
    public ResponseEntity<ProductResponse> getProductByProductName(@PathVariable String productName) {
        return productService.getByName(productName);
    }

    @GetMapping("/GetProductsByBrandName/{brand}")
    public ResponseEntity<ProductResponse> getProductByBrandName(@PathVariable String brand) {
        return productService.getProductByBrandName(brand);
    }

    @GetMapping("/GetAllProducts")
    public ResponseEntity<ProductResponse> getAllProduct(@RequestParam Optional<String> pageIndex,
                                                         @RequestParam Optional<String> pageSize,
                                                         @RequestParam Optional<String> brandId,
                                                         @RequestParam Optional<String> typeId,
                                                         @RequestParam Optional<String> sort,
                                                         @RequestParam Optional<String> search) {

        return productService.getAllProducts(pageIndex, pageSize, brandId, typeId, sort, search);
    }

    @PostMapping("/CreateProduct")
    @Validated(OnCreate.class)
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDTO) {
        return productService.create(productDTO);
    }

    @PutMapping("/UpdateProduct/{productId}")
    @Validated(OnUpdate.class)
    public ResponseEntity<ProductDTO> update(@Valid @RequestBody ProductDTO productDTO, @PathVariable String productId) {
        return productService.update(productDTO, productId);
    }

    @DeleteMapping("/{id}/DeleteProduct")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return productService.delete(id);
    }
}
