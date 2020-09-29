package com.bse.RequestSpringBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bse.RequestSpringBootApp.dto.EmployeeDto;
import com.bse.RequestSpringBootApp.service.RequestAppService;

@RestController
public class RequestAppController {

	@Autowired
	private RequestAppService RequestAppService;
	@GetMapping("info/employee")
	public EmployeeDto getEmpInfo(@RequestParam("paygroup") String payGroup, @RequestHeader("company-id") String companyId) {
		EmployeeDto empDto = null;
		empDto = RequestAppService.getDetails(payGroup,companyId);
		return empDto;
	}

}
