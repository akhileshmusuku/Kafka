package com.akhil.kafkaconsumer.dbentity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductData")
public class ProductEntity {
	
	@Id
	private long id;
	private String name;
	private double price;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}


	

}