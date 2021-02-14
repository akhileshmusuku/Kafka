package com.akhil.kafkaconsumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.akhil.kafkaconsumer.model.ProductVo;
import com.akhil.kafkaconsumer.service.ProductService;

@Service
public class ProductListener {
	
	@Autowired
	private ProductService productService;
	
	@KafkaListener(topics = "Product_Data", containerFactory = "productContainerFactory")
	public void consume(ProductVo message) {
		System.out.println("consumed message product :"+message);
		
		productService.addProduct(message);
		
		
	}

}
