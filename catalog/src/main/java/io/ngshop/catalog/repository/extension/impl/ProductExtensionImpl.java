package io.ngshop.catalog.repository.extension.impl;

import io.ngshop.catalog.exception.NotFoundException;
import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.repository.BrandRepository;
import io.ngshop.catalog.repository.extension.ProductExtension;
import io.ngshop.catalog.service.impl.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductExtensionImpl implements ProductExtension {
    private final MongoTemplate mongoTemplate;
    private final BrandRepository brandRepository;

    @Override
    public List<Product> findAllWithPagination(Optional<String> pageIndex, Optional<String> pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search) {
        Query query = new Query();
        brandId.ifPresent(value -> query.addCriteria(Criteria.where("brandId").is(CommonService.checkObjectId(value))));
        typeId.ifPresent(value -> query.addCriteria(Criteria.where("typeId").is(CommonService.checkObjectId(value))));

        if (pageIndex.isPresent() && pageSize.isPresent()){
            if (!(pageIndex.get().equals("null") || pageSize.get().equals("null"))) {
                query.with(PageRequest.of(Integer.parseInt(pageIndex.get())-1, Integer.parseInt(pageSize.get())));
            }
        }
        sort.ifPresent(s -> query.with(Sort.by("name")));

        return mongoTemplate.find(query, Product.class);
    }

    @Override
    public List<Product> findByBrandName(String brand){
        Brand brand1 = brandRepository.findBrandByName(brand).orElseThrow(() -> new NotFoundException("Brand not found"));
        Query query = new Query();
        query.addCriteria(Criteria.where("brandId").is(brand1.getId()));
        return mongoTemplate.find(query,Product.class);
    }
}
