package io.ngshop.catalog.repository.extension.impl;

import io.ngshop.catalog.dto.ProductResponse;
import io.ngshop.catalog.exception.NotFoundException;
import io.ngshop.catalog.mapper.ProductMapper;
import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.repository.BrandRepository;
import io.ngshop.catalog.repository.extension.ProductExtension;
import io.ngshop.catalog.service.imp.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductExtensionImpl implements ProductExtension {
    private final MongoTemplate mongoTemplate;
    private final BrandRepository brandRepository;
    private final ProductMapper productMapper;


    @Override
    public ResponseEntity<ProductResponse> findAllWithPagination(Integer pageIndex, Integer pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search) {
        Query query = new Query();
        brandId.ifPresent(value -> query.addCriteria(Criteria.where("brandId").is(CommonService.checkObjectId(value))));
        typeId.ifPresent(value -> query.addCriteria(Criteria.where("typeId").is(CommonService.checkObjectId(value))));
        search.ifPresent(value -> query.addCriteria(Criteria.where("name").regex(value)));

        List<Product> allResults = mongoTemplate.find(query,Product.class);

        query.with(PageRequest.of(pageIndex-1, pageSize));
        sort.ifPresent(s -> {
            if (Set.of("name","id","price","description","summary","bradId","typeId").contains(s)) query.with(Sort.by(s));
        });

        List<Product> products = mongoTemplate.find(query, Product.class);

        return ResponseEntity.ok(new ProductResponse(
                pageIndex,
                pageSize,
                allResults.size(),
                products.stream().map(productMapper::toDto).collect(Collectors.toList())
        ));
    }

    @Override
    public List<Product> findByBrandName(String brand){
        Brand brand1 = brandRepository.findBrandByName(brand).orElseThrow(() -> new NotFoundException("Brand not found"));
        Query query = new Query();
        query.addCriteria(Criteria.where("brandId").is(brand1.getId()));
        return mongoTemplate.find(query,Product.class);
    }
}
