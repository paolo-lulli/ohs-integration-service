package com.volvo.ohs.dto;


public class ProductDto {
	  String pid;
	  Double pricePerUnit;
	  String name;

	private ProductDto(Builder builder) {
		this.pid = builder.pid;
		this.pricePerUnit = builder.pricePerUnit;
		this.name = builder.name;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String pid;
		private Double pricePerUnit;
		private String name;

		private Builder() {
		}

		public Builder withPid(String pid) {
			this.pid = pid;
			return this;
		}

		public Builder withPricePerUnit(Double pricePerUnit) {
			this.pricePerUnit = pricePerUnit;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public ProductDto build() {
			return new ProductDto(this);
		}
	}

	public String getPid() {
		return pid;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "ProductDto [pid=" + pid + ", pricePerUnit=" + pricePerUnit + ", name=" + name + "]";
	}
	
}
