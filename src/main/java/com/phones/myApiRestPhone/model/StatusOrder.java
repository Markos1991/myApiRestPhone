package com.phones.myApiRestPhone.model;

public enum StatusOrder {

	VALIDATED, INCORRECT, CANCELLED, CREATING;
	
	public static StatusOrder statusOrderFromString(String status) {
		switch (status) {
		case "Validated":
			return VALIDATED;
		case "Incorret":
			return INCORRECT;
		case "Cacelled":
			return CANCELLED;
		case "Creating":
			return CREATING;
		default:
			return null;
		}
	}
	
}
