package com.phones.myApiRestPhone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	
	// Attributes
	
	// Primary key
	@Id
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	// Builders
	
	public User() {}
	
	public User(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// Getters & Setters methods
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Methods
	
	public String toString() {
		return "\t \t - First name: " + firstName + "\n" + 
				"\t \t - Last name: " + lastName + "\n" +
				"\t \t - Email: " + email + "\n"; 
	}
	

}
