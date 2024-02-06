package com.programming.productservice.repository;

import com.programming.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * Repository interface for managing Product entities in MongoDB.
 */
public interface ProductRepository extends MongoRepository<Product,String > {
}
