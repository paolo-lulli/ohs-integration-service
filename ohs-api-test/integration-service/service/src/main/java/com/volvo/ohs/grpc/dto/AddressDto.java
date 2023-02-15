package com.volvo.ohs.grpc.dto;

public class AddressDto {
	private final String country;
	private final String address;

	public AddressDto(String country, String address) {
		super();
		this.country = country;
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public String getAddress() {
		return address;
	}
}
