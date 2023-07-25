package io.ngshop.catalog.service.imp;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.exception.NotFoundException;
import io.ngshop.catalog.mapper.BrandMapper;
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
    public ResponseEntity<List<BrandDto>> findAll() {
        return ResponseEntity.ok(brandRepository.findAll().stream().map(brandMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<BrandDto> create(BrandDto brandDto) {
        Brand brand = brandMapper.toEntity(brandDto);
        return ResponseEntity.ok(brandMapper.toDto(brandRepository.save(brand)));
    }

    @Override
    public ResponseEntity<BrandDto> update(String id, BrandDto brand) {
        ObjectId objectId = CommonService.checkObjectId(id);
        Brand brandObj = brandRepository.findById(objectId).orElseThrow(() -> new NotFoundException("Brand not found"));
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
