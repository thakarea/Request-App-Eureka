package com.bse.RequestSpringBootApp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bse.RequestSpringBootApp.dto.EmployeeDto;

@Service
public class RequestAppService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discovery;

	public EmployeeDto getDetails(String paygroup, String companyId) {
		
		List<ServiceInstance> serviceInstance =	discovery.getInstances("RESPOSE-PRODUCER-APP");
		ServiceInstance instance = serviceInstance.get(0);
		String  baseUrl = instance.getUri().toString();
		ResponseEntity<EmployeeDto> empDto = null;
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.set("company-id", companyId);
		HttpEntity<String> entity = new HttpEntity<String>(header);
		empDto = restTemplate.exchange(baseUrl+"/emplDetail/bse?payGroup=" + paygroup, HttpMethod.GET,entity, EmployeeDto.class);
		return empDto.getBody();
	}

}
