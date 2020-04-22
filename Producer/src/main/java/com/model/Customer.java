package com.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Customer Number must not be null")
	@Pattern(regexp = "[C][0-9]{9}", message = "Invalid Customer Number It should be C000000001 format, starts with C and followed by 9 digits")
	private String customerNumber;

	@NotNull(message = "First Name must not be null")
	@Size(min = 10, max = 50, message = "First Name must be 10 to 50 Charecters")
	private String firstName;

	@NotNull(message = "Last Name must not be null")
	private String lastName;

	@NotNull(message = "Birth Date must be dd/mm/yyyy format")
	@Pattern(regexp = "^[0-3]?[0-9]-[0-3]?[0-9]-(?:[0-9]{2})?[0-9]{2}$", message = "Invalid date of birth It Must be dd-mm-yyyy")
	private String birthdate;

	@NotNull(message = "Country must not be null")
	private String country;

	@NotNull(message = "Country Code must not be null")
	@Size(max = 2, message = "Country Code must be 2 Charecters")
	@Pattern(regexp = "[A-Z]{2}", message = "Country Code must be 2 Charecters Ex: IN / US / UK")
	private String countryCode;

	@NotNull(message = "Mobile Number must not be null")
	@Size(min = 10, max = 10, message = "Mobile Number must be 10 Digits")
	private String mobileNumber;

	@Email
	@NotNull(message = "Email must not be null")
	private String email;

	@NotNull(message = "Customer Status must not be null")
	private CustomerStatus customerStatus;

	@NotNull
	private Address address;

	public Customer() {
	}

	public Customer(String customerNumber, String firstName, String lastName, String birthdate, String country,
			String countryCode, String mobileNumber, String email, CustomerStatus customerStatus, Address address) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.country = country;
		this.countryCode = countryCode;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.customerStatus = customerStatus;
		this.address = address;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerStatus getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthdate=" + birthdate + ", country=" + country + ", countryCode=" + countryCode
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", customerStatus=" + customerStatus
				+ ", address=" + address + "]";
	}

}
