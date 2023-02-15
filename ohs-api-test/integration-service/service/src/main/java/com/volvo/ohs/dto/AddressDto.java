package com.volvo.ohs.dto;

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

	@Override
	public String toString() {
		return "AddressDto [country=" + country + ", address=" + address + "]";
	}
}
