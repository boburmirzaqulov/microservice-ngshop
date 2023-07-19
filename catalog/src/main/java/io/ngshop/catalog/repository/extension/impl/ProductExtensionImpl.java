package io.ngshop.catalog.repository.extension.impl;

import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.repository.extension.ProductExtension;
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

    @Override
    public List<Product> findAllWithPagination(Optional<Integer> pageIndex, Optional<Integer> pageSize, Optional<ObjectId> brandId, Optional<ObjectId> typeId, Optional<String> sort, Optional<String> search) {
        Query query = new Query();
        brandId.ifPresent(value -> query.addCriteria(Criteria.where("brandId").is(value.toString())));
        typeId.ifPresent(value -> query.addCriteria(Criteria.where("typeId").is(value.toString())));

        if (pageIndex.isPresent() && pageSize.isPresent()){
            query.with(PageRequest.of(pageIndex.get(), pageSize.get()));
        }
        sort.ifPresent(s -> query.with(Sort.by(s)));

        return mongoTemplate.find(query, Product.class);
    }
}
