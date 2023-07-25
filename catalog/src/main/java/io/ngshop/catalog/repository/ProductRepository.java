package io.ngshop.catalog.repository;

import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.repository.extension.ProductExtension;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId>, ProductExtension {
    List<Product> findByName(String name);

}
