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
public class FlightMSConsumer {
	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public Iterable<Flight> listofFlights(){
		List<ServiceInstance> list = discoveryClient.getInstances("flight-microservice");
		ServiceInstance serviceInstance = list.get(0);
		URI uri = serviceInstance.getUri();
		
		if(serviceInstance != null && serviceInstance.getUri() != null){
			try {
				return (Iterable<Flight>)(new RestTemplate().getForEntity(new URI(uri.toString().concat("/flights")),Iterable.class).getBody());
			} catch (RestClientException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
