package com.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class MyResource {
	
	@RequestMapping("/")
	public Order getOrder() {
		return new Order("order1");
	}
	
	@RequestMapping("/findByName")
	public HttpEntity<Order> getOrderByName(@RequestParam(value="name",required=false,defaultValue="order1") String name){
		Order order = new Order("order 123");
		order.add(linkTo(methodOn(MyResource.class).getOrderByName(name)).withSelfRel());

		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
}
