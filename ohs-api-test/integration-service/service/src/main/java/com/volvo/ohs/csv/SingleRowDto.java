package com.volvo.ohs.csv;

public class SingleRowDto {
// id,first_name,last_name,email,supplier_pid,credit_card_number,credit_card_type,order_id,product_pid,shipping_address,country,date_created,quantity,full_name,order_status
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String supplierPid;
	private String creditCardNumber;
	private String creditCardType;
	private String orderId;
	private String productPid;
	private String shippingAddress;
	private String country;
	private String dateCreated;
	private String quantity;
	private String fullName;
	private String orderStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSupplierPid() {
		return supplierPid;
	}

	public void setSupplierPid(String supplierPid) {
		this.supplierPid = supplierPid;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductPid() {
		return productPid;
	}

	public void setProductPid(String productPid) {
		this.productPid = productPid;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "SingleRowDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", supplierPid=" + supplierPid + ", creditCardNumber=" + creditCardNumber + ", creditCardType="
				+ creditCardType + ", orderId=" + orderId + ", productPid=" + productPid + ", shippingAddress="
				+ shippingAddress + ", country=" + country + ", dateCreated=" + dateCreated + ", quantity=" + quantity
				+ ", fullName=" + fullName + ", orderStatus=" + orderStatus + "]";
	}

}
