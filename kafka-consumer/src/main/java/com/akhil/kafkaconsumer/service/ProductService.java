package com.akhil.kafkaconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.kafkaconsumer.dbentity.ProductEntity;
import com.akhil.kafkaconsumer.model.ProductVo;
import com.akhil.kafkaconsumer.repo.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	public void addProduct(ProductVo message) {
		ProductEntity productEntity = new ProductEntity();
		
		productEntity.setId(message.getId());
		productEntity.setName(message.getName());
		productEntity.setPrice(message.getPrice());
		productEntity.setDescription(message.getDescription());
		
		productDao.saveProduct(productEntity);
	}

}
