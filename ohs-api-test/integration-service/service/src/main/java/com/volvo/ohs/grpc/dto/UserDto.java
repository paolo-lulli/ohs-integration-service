package com.volvo.ohs.grpc.dto;

import java.util.List;
import java.util.Collections;

public class UserDto {
	// id,first_name,last_name,email,
	/*
	 * message CreateUserRequest { google.protobuf.StringValue fullName = 1; string
	 * email = 2; ShippingAddress address = 3; repeated PaymentMethod paymentMethods
	 * = 4; google.protobuf.StringValue password = 5; }
	 */
	private final String fullName;
	private final String email;
	private final List<AddressDto> addresses;

	private UserDto(Builder builder) {
		this.fullName = builder.fullName;
		this.email = builder.email;
		this.addresses = builder.addresses;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String fullName;
		private String email;
		private List<AddressDto> addresses = Collections.emptyList();

		private Builder() {
		}

		public Builder withFullName(String fullName) {
			this.fullName = fullName;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withAddresses(List<AddressDto> addresses) {
			this.addresses = addresses;
			return this;
		}

		public UserDto build() {
			return new UserDto(this);
		}
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public List<AddressDto> getAddresses() {
		return addresses;
	}
}
