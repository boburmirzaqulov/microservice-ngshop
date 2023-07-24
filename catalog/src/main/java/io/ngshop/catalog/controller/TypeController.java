package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.TypeDTO;
import io.ngshop.catalog.groups.OnCreate;
import io.ngshop.catalog.groups.OnUpdate;
import io.ngshop.catalog.service.TypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class TypeController {
    private final TypeService typeService;

    @GetMapping("GetAllTypes")
    public ResponseEntity<List<TypeDTO>> getAllBrands(){
        return typeService.findAll();
    }

    @PostMapping("CreateType")
    @Validated(OnCreate.class)
    public ResponseEntity<TypeDTO> create(@Valid @RequestBody TypeDTO typeDto){
        return typeService.create(typeDto);
    }

    @PutMapping("UpdateType")
    @Validated(OnUpdate.class)
    public ResponseEntity<TypeDTO> update(@Valid @RequestBody TypeDTO typeDto){
        return typeService.update(typeDto);
    }
}
