package com.akhil.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhil.kafkaproducer.dao.ProductDao;
import com.akhil.kafkaproducer.model.Product;
import com.akhil.kafkaproducer.model.ResponseVo;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	public ResponseVo postMessage(Product request) {
		
		return productDao.postMessage(request);
		
	}

}
