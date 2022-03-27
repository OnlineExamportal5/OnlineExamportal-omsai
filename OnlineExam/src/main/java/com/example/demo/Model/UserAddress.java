package com.example.demo.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//@Validated
@Entity
@Table(name="address")
public class UserAddress implements Serializable {
private static final long serialVersionUID=1L;
@Id
@Column(name="ADDRESS_ID")
@GeneratedValue(strategy=GenerationType.AUTO)
private int addressId;

@Column(name="ADDRESS_COUNTRY")
private String country;

@Column(name="ADDRESS_STATE")
private String state;

@Column(name="ADDRESS_CITY")
private String city;

@Column(name="ADDRESS_ZIPCODE")
private String zipCode;



public UserAddress() {
	super();
}



public UserAddress(String country, String state, String city, String zipCode) {
	super();
	
	this.country = country;
	this.state = state;
	this.city = city;
	this.zipCode = zipCode;
}



public int getAddressId() {
	return addressId;
}

public void setAddressId(int addressId) {
	this.addressId = addressId;
}

public String getCountry() {
	return country;
}

public void setStreet(String country) {
	this.country = country;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getZipCode() {
	return zipCode;
}

public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}

@Override
public String toString() {
	return "UserAddress [addressId=" + addressId + ", country=" + country + ", state=" + state + ", city=" + city
			+ ", zipCode=" + zipCode + "]";
}


}





