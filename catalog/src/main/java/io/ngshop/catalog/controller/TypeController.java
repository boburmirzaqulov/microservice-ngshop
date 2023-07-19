package io.ngshop.catalog.controller;

import io.ngshop.catalog.model.Type;
import io.ngshop.catalog.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TypeController {
    private final TypeService typeService;

    @GetMapping("GetAllTypes")
    public ResponseEntity<List<Type>> getAllBrands(){
        return typeService.findAll();
    }
}
