package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final ProductService productService;
    @GetMapping("/GetProductById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id){
        return productService.getProductById(new ObjectId(id));
    }


    @GetMapping("/GetProductByProductName/{productName}")
    public ResponseEntity<List<ProductDTO>> getProductByProductName(@PathVariable String productName){
        return productService.getByName(productName);
    }

    @GetMapping("/GetProductsByBrandName/{brand}")
    public ResponseEntity<List<ProductDTO>> getProductByBrand(@PathVariable String brand){
        return productService.getProductByBrand(brand);
    }

    @GetMapping("/GetAllProducts")
    public ResponseEntity<List<ProductDTO>> getAllProduct(@RequestParam Optional<Integer> pageIndex,
                                                          @RequestParam Optional<Integer> pageSize,
                                                          @RequestParam Optional<ObjectId> brandId,
                                                          @RequestParam Optional<ObjectId> typeId,
                                                          @RequestParam Optional<String> sort,
                                                          @RequestParam Optional<String> search){
        return productService.getAllProducts(pageIndex,pageSize,brandId,typeId,sort,search);
    }

    @PostMapping("/CreateProduct")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO){
        return productService.create(productDTO);
    }

    @PutMapping("/UpdateProduct")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO){
        return productService.update(productDTO);
    }

    @DeleteMapping("/{id}/DeleteProduct")
    public ResponseEntity<ProductDTO> delete(@PathVariable String id){
        return productService.delete(id);
    }
}
