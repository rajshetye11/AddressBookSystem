package com.bridgelabz.addressbooksystem;

public class ContactAddressBook {
	
	String firstname;
	String lastname;
	String address;
	String city;
	String state;
	int zipcode;
	String phonenum;
	String email;
	
	ContactAddressBook(String firstname, String lastname, String address, 
						String city, String state, int zipcode, String phonenum, 
						String email){
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address; 
		this.city = city; 
		this.state = state;
		this.zipcode = zipcode;
		this.phonenum=phonenum; 
		this.email=email;
		
	}

	@Override
	public String toString() {
		return "ContactAddressBook [firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", phonenum=" + phonenum + ", email="
				+ email + "]";
	}
	
	
}
