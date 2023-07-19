package io.ngshop.catalog.service.impl;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.exception.NotFoundException;
import io.ngshop.catalog.exception.WrongObjectIdException;
import io.ngshop.catalog.mapper.BrandMapper;
import io.ngshop.catalog.mapper.ProductMapper;
import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.repository.BrandRepository;
import io.ngshop.catalog.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public ResponseEntity<List<Brand>> findAll() {
        return ResponseEntity.ok(brandRepository.findAll());
    }

    @Override
    public ResponseEntity<BrandDto> create(BrandDto brandDto) {
        Brand brand = brandMapper.toEntity(brandDto);
        return ResponseEntity.ok(brandMapper.toDto(brandRepository.save(brand)));
    }

    @Override
    public ResponseEntity<BrandDto> update(String id, BrandDto brand) {
        if (id.length() != 24){
            throw new WrongObjectIdException("Wrong brand id");
        }
        Brand brandObj = brandRepository.findById(new ObjectId(id)).orElseThrow(() -> new NotFoundException("Brand not found"));
        brandObj.setName(brand.getName());
        Brand save = brandRepository.save(brandObj);
        return ResponseEntity.ok(brandMapper.toDto(save));
    }

    @Override
    public ResponseEntity<BrandDto> delete(String brandId) {
        Brand brand = brandRepository.findById(new ObjectId(brandId)).orElseThrow(() -> new NotFoundException("Brand not found"));
        brandRepository.delete(brand);
        return ResponseEntity.ok(brandMapper.toDto(brand));
    }
}
