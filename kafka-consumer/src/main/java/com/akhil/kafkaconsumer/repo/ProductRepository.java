package com.akhil.kafkaconsumer.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.akhil.kafkaconsumer.dbentity.ProductEntity;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, Long>{

}
