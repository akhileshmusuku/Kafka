package com.akhil.kafkaconsumer.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akhil.kafkaconsumer.dbentity.ProductEntity;

@Component
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;

	public void saveProduct(ProductEntity request) {
		productRepository.save(request);
	}

}
