package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.dto.TypeDto;
import io.ngshop.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService productService;
    @GetMapping("/GetProductById/{id}")
        public ResponseEntity<ProductDto> getProductById(@PathVariable String id){
            return productService.getProductById(new ObjectId(id));
    }
    @GetMapping("GetProductByProductName/{productName}")
    public ResponseEntity<List<ProductDto>> getProductByProductName(@PathVariable String productName){
        return productService.getProductByProductName(productName);
    }
    @GetMapping("GetAllProducts")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("GetAllBrands")
    public ResponseEntity<List<BrandDto>> getAllBrands(){
        return productService.getAllBrands();
    }
    @GetMapping("GetAllTypes")
    public ResponseEntity<List<TypeDto>> getAllTypes(){
        return productService.getAllTypes();
    }
    @GetMapping("GetProductsByBrandName/{brand}")
    public ResponseEntity<List<ProductDto>> getProductsByBrandName(@PathVariable String brand){
        return productService.getProductsByBrandName(brand);
    }
    @PostMapping("CreateProduct")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }
    @PutMapping("UpdateProduct")
    public boolean updateProduct(@RequestBody ProductDto productDto){
        return productService.updateProduct(productDto);
    }
    @DeleteMapping("{id}")
    public boolean deleteProduct(@PathVariable String id){
        return productService.deleteProduct(new ObjectId(id));
    }
}
