package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.dto.ProductResponse;
import io.ngshop.catalog.dto.TypeDto;
import io.ngshop.catalog.service.BrandService;
import io.ngshop.catalog.service.ProductService;
import io.ngshop.catalog.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Catalog")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class CatalogController {
    private final ProductService productService;
    private final TypeService typeService;
    private final BrandService brandService;



    @GetMapping("GetAllBrands")
    public ResponseEntity<List<BrandDto>> getAllBrands(){
        return brandService.findAll();
    }

    @GetMapping("GetAllTypes")
    public ResponseEntity<List<TypeDto>> getAllTypes(){
        return typeService.findAll();
    }

    @GetMapping("/GetProductById/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }


    @GetMapping("/GetProductByProductName/{productName}")
    public ResponseEntity<List<ProductDto>> getProductByProductName(@PathVariable String productName){
        return productService.getByName(productName);
    }

    @GetMapping("/GetProductsByBrandName/{brand}")
    public ResponseEntity<List<ProductDto>> getProductByBrandName(@PathVariable String brand){
        return productService.getProductByBrandName(brand);
    }

    @GetMapping("/GetAllProducts")
    public ResponseEntity<ProductResponse> getAllProduct(@RequestParam Integer pageIndex,
                                                         @RequestParam Integer pageSize,
                                                         @RequestParam Optional<String> brandId,
                                                         @RequestParam Optional<String> typeId,
                                                         @RequestParam Optional<String> sort,
                                                         @RequestParam Optional<String> search){
        return productService.getAllProducts(pageIndex,pageSize,brandId,typeId,sort,search);
    }

    @PostMapping("/CreateProduct")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDTO){
        return productService.create(productDTO);
    }

    @PutMapping("/UpdateProduct/{productId}")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDTO, @PathVariable String productId){
        return productService.update(productDTO,productId);
    }

    @DeleteMapping("/{id}/DeleteProduct")
    public ResponseEntity<ProductDto> delete(@PathVariable String id){
        return productService.delete(id);
    }
}
