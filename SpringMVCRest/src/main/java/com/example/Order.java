package com.example;

import org.springframework.hateoas.ResourceSupport;

public class Order extends ResourceSupport {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Order(String message) {
		super();
		this.message = message;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}
}
