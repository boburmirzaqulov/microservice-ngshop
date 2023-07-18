package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final ProductService productService;
    @GetMapping("/GetProductById/{id}")
        public ResponseEntity<ProductDTO> getProductById(@PathVariable String id){
            return productService.getProductById(new ObjectId(id));
    }


}
