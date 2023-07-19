package io.ngshop.catalog.controller;

import io.ngshop.catalog.dto.TypeDto;
import io.ngshop.catalog.groups.OnCreate;
import io.ngshop.catalog.groups.OnUpdate;
import io.ngshop.catalog.model.Type;
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
public class TypeController {
    private final TypeService typeService;

    @GetMapping("GetAllTypes")
    public ResponseEntity<List<TypeDto>> getAllBrands(){
        return typeService.findAll();
    }

    @PostMapping("CreateType")
    @Validated(OnCreate.class)
    public ResponseEntity<TypeDto> create(@Valid @RequestBody TypeDto typeDto){
        return typeService.create(typeDto);
    }

    @PutMapping("UpdateType")
    @Validated(OnUpdate.class)
    public ResponseEntity<TypeDto> update(@Valid @RequestBody TypeDto typeDto){
        return typeService.update(typeDto);
    }
}
