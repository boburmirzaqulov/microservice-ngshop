package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    @GetMapping("//")
    public String getAd(){
        return "alfkdjlkfjafdas;flkjsdf";
    }

        @Autowired
        private ProductService productService;



        @GetMapping
        public ResponseEntity<List<ProductDTO>> getAllProducts() {
            return productService.getAllProducts();
        }

        @GetMapping("/{id}")
        public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
           return productService.getProductById(id);
        }

        @PostMapping
        public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {

            return productService.createProduct(productDTO);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
           return productService.updateProduct(productDTO);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
           return productService.deleteProduct(id);
        }


}
