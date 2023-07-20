package io.ngshop.catalog.repository.ex.impl;

import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.repository.BrandRepository;
import io.ngshop.catalog.repository.ex.ProductRepositoryExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductRepositoryExtensionImpl implements ProductRepositoryExtension {
    private final BrandRepository brandRepository;
    private final MongoTemplate mongoTemplate;
    @Override
    public List<Product> getProductsByBrandName(String brandName) {
        Brand brand = brandRepository.findByName(brandName).orElseThrow();
        Query query = new Query();
        query.addCriteria(Criteria.where("brandId").is(brand.getId()));
        return mongoTemplate.find(query, Product.class);
    }
}
