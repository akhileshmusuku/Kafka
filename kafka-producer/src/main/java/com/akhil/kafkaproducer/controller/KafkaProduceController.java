package com.akhil.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhil.kafkaproducer.model.Product;
import com.akhil.kafkaproducer.model.ResponseVo;
import com.akhil.kafkaproducer.service.ProductService;

@RestController
@RequestMapping("/kafka")
public class KafkaProduceController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/product", consumes= {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseVo> postKafkaMessage(@RequestBody Product request){
		
		ResponseVo response = productService.postMessage(request);
		
		return new ResponseEntity<ResponseVo>(response, HttpStatus.OK) ;
		
	}

}
