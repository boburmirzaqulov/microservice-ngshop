package io.ngshop.catalog.service;

import io.ngshop.catalog.model.Type;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeService {
    ResponseEntity<List<Type>> findAll();
}
