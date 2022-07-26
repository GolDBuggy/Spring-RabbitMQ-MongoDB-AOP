package com.java.mongosql.Repository;

import com.java.mongosql.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

    public Product findByName(String name);
    public Product deleteByName(String name);
}
