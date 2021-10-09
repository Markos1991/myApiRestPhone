package com.phones.myApiRestPhone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "phone")
public class Phone {
	
	// Attributes
	
	// Primary key
	@Id
	private String ref;
	
	private String name;
	
	private String image;
	
	private double price;
	
	private String description;
	
	// Builders
	
	public Phone() {}
	
	public Phone(String ref, String name, String image, double price, String des) {
		this.ref = ref;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = des;
	}
	
	// Getters & Setters methods
	
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDes() {
		return description;
	}

	public void setDes(String des) {
		this.description = des;
	}
	
	// Methods
	
	public String toString() {
		return "[ref=" + this.ref + ", name=" + name + ", image=" + image + ", price=" + price
                + ", description=" + description + "]";
	}
	
	public String overviewPhone() {
		return "Phone name: " + name;
	}
	
	
}
