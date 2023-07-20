package io.ngshop.catalog.repository.ex.impl;

import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.dto.response.ProductResponse;
import io.ngshop.catalog.mapper.ProductMapper;
import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.repository.BrandRepository;
import io.ngshop.catalog.repository.ex.ProductRepositoryExtension;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductRepositoryExtensionImpl implements ProductRepositoryExtension {
    private final BrandRepository brandRepository;
    private final ProductMapper productMapper;
    private final MongoTemplate mongoTemplate;
    @Override
    public List<Product> getProductsByBrandName(String brandName) {
        Brand brand = brandRepository.findByName(brandName).orElseThrow();
        Query query = new Query();
        query.addCriteria(Criteria.where("brandId").is(brand.getId()));
        return mongoTemplate.find(query, Product.class);
    }

    @Override
    public ProductResponse findAllWithPagination(Optional<String> pageIndex, Optional<String> pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search) {
        Query query = new Query();
        brandId.ifPresent(value -> query.addCriteria(Criteria.where("brandId").is(new ObjectId(value))));
        typeId.ifPresent(value -> query.addCriteria(Criteria.where("typeId").is(new ObjectId(value))));
        search.ifPresent(value -> query.addCriteria(Criteria.where("name").regex(value.toLowerCase())));
        int size = mongoTemplate.find(query, Product.class).size();
        if (pageIndex.isPresent() && pageSize.isPresent()){
            if (!(pageIndex.get().equals("null") || pageSize.get().equals("null"))) {
                query.with(PageRequest.of(Integer.parseInt(pageIndex.get())-1, Integer.parseInt(pageSize.get())));
            }
        }
        sort.ifPresent(s -> {
            if (Set.of("name","id","price","description","summary","bradId","typeId").contains(s)) query.with(Sort.by(s));
        });

        List<ProductDto> list = mongoTemplate.find(query, Product.class).stream().map(productMapper::toDto).toList();
        return ProductResponse.builder().data(list).pageIndex(Integer.valueOf(pageIndex.get())).pageSize(Integer.valueOf(pageSize.get())).count(size).build();

    }
}
