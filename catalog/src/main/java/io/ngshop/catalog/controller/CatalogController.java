package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.dto.TypeDto;
import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Type;
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
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }


    @GetMapping("/GetProductByProductName/{productName}")
    public ResponseEntity<List<ProductDTO>> getProductByProductName(@PathVariable String productName){
        return productService.getByName(productName);
    }

    @GetMapping("/GetProductsByBrandName/{brand}")
    public ResponseEntity<List<ProductDTO>> getProductByBrandName(@PathVariable String brand){
        return productService.getProductByBrandName(brand);
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

    @PutMapping("/UpdateProduct/{productId}")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO, @PathVariable String productId){
        return productService.update(productDTO,productId);
    }

    @DeleteMapping("/{id}/DeleteProduct")
    public ResponseEntity<ProductDTO> delete(@PathVariable String id){
        return productService.delete(id);
    }
}
