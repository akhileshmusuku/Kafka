package com.akhil.kafkaproducer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

import com.akhil.kafkaproducer.model.Product;
import com.akhil.kafkaproducer.model.ResponseVo;

@Repository
public class ProductDao {
	
	@Value("${kafka.topic}")
	private String TOPIC;

	@Autowired
	private KafkaTemplate<String, Product> kafkaTemplate;
	
	public ResponseVo postMessage(Product request) {
		
		kafkaTemplate.send(TOPIC, request);
		
		return new ResponseVo("message published successfully", "200");
		
		
	}

}
