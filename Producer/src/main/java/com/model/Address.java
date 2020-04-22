package com.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "addressLine1 must not be null")
	@Size(max = 50, message = "addressLine1 must be less than 50 Charecters")
	private String addressLine1;

	private String addressLine2;

	private String street;

	@NotNull(message = "postalCode must not be null")
	@Size(max = 5, message = "postalCode max 5 Charecters")
	private String postalCode;

	public Address() {
	}

	public Address(String addressLine1, String addressLine2, String street, String postalCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.street = street;
		this.postalCode = postalCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", street=" + street
				+ ", postalCode=" + postalCode + "]";
	}

}
