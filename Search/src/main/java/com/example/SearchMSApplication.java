package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import com.example.component.FlightRepository;
import com.example.model.Fares;
import com.example.model.Flight;
import com.example.model.Inventory;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SearchMSApplication implements CommandLineRunner {
	
	@Autowired
	private FlightRepository flightRepository;

	public static void main(String[] args) {
		SpringApplication.run(SearchMSApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		List<Flight> list = new ArrayList<>();
		list.add(new Flight(1, "AT02", "BLR","DL","23-OCT-16", new Fares("5000", "INR"),new Inventory(50)));
		list.add(new Flight(2, "BT01", "DL","BLR","27-OCT-16", new Fares("8000", "INR"),new Inventory(90)));
		list.add(new Flight(3, "ZT01", "GWT","DL","01-SEP-16", new Fares("9000", "INR"),new Inventory(80)));
		flightRepository.save(list);
	}
}
