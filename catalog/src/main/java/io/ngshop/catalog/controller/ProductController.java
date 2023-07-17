package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog")
public class ProductController {
    private final MongoTemplate mongoTemplate;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return productService.create(productDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll(){
        return productService.getProducts();
    }
}
