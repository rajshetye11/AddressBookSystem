package com.bridgelabz.addressbooksystem;

import java.util.Arrays;
import java.util.Scanner;

public class AddressBook {
	ContactAddressBook[] arr = new ContactAddressBook[10];
	public int i=0;
	
	public void addContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name : ");
		String firstname= sc.nextLine();
		System.out.println("Enter Last Name : ");
		String lastname= sc.nextLine();
		System.out.println("Enter Address : ");
		String address= sc.nextLine();
		System.out.println("Enter City : ");
		String city= sc.nextLine();
		System.out.println("Enter State : ");
		String state= sc.nextLine();
		System.out.println("Enter ZipCode : ");
		int zipcode=sc.nextInt(); 
		System.out.println("Enter Phone Number : ");
		int phonenum=sc.nextInt();
		System.out.println("Enter Email id : ");
		String email= sc.next();	
		
		arr[i]= new ContactAddressBook(firstname,lastname,address,city,state,zipcode,phonenum,email);
		System.out.println("Contact added Successfully");
		System.out.println(arr[i]);
		
		
	}
	
	
@Override
	public String toString() {
		return "AddressBook [arr=" + Arrays.toString(arr) + ", i=" + i + "]";
	}


public static void main(String[] args) {

	System.out.println("Welcome To Address Book Program");
	AddressBook ab= new AddressBook();
	ab.addContact();
	System.out.println("Thankyou");
	
}
}
