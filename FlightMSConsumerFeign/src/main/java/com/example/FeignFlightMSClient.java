package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.model.Flight;

@RestController
public class FeignFlightMSClient {
	@Autowired
	FlightMicroServiceConsumer discoveryClient;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Iterable<Flight> listofFlights(){
		return discoveryClient.listofFlights();
	}
}
