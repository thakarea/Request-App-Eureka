package com.bse.RequestSpringBootApp.dto;

public class EmployeeDto {
	private int emplid;
	private String name;
	private String address;
	private String paygroup;

	
	public EmployeeDto() {
	}

	public EmployeeDto(int emplid, String name, String address, String paygroup) {
		super();
		this.emplid = emplid;
		this.name = name;
		this.address = address;
		this.paygroup = paygroup;
	}

	public String getPaygroup() {
		return paygroup;
	}

	public void setPaygroup(String paygroup) {
		this.paygroup = paygroup;
	}

	public int getEmplid() {
		return emplid;
	}

	public void setEmplid(int emplid) {
		this.emplid = emplid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
