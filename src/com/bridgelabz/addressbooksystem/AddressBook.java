package com.bridgelabz.addressbooksystem;

import java.util.Arrays;
import java.util.Scanner;

public class AddressBook {
	
	ContactAddressBook[] arr ;
	public int i=0;
	
	public void addContact() 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of entries: ");
		int record = sc.nextInt();
		arr = new ContactAddressBook[record];
		for(int i=0;i<record;i++) {
		System.out.println("Enter First Name : ");
		String firstname= sc.next();
		System.out.println("Enter Last Name : ");
		String lastname= sc.next();
		System.out.println("Enter Address : ");
		String address= sc.next();
		System.out.println("Enter City : ");
		String city= sc.next();
		System.out.println("Enter State : ");
		String state= sc.next();
		System.out.println("Enter ZipCode : ");
		int zipcode=sc.nextInt(); 
		System.out.println("Enter Phone Number : ");
		String phonenum=sc.next();
		System.out.println("Enter Email id : ");
		String email= sc.next();	
		
		arr[i]= new ContactAddressBook(firstname,lastname,address,city,state,zipcode,phonenum,email);
		System.out.println("Contact created Successfully");
	}		
	}
	
	
	
	 public void showContact(){
	      	for (int i=0; i < arr.length; i++) {
	      		if(arr[i]!=null) {
	      			System.out.println(arr[i]);
	      		}
	      	}
	      }
	
	 public void editContact() {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Enter First Name to edit that entry from Contact Books ");
	    	String name = sc.next();
	    	for (int j=0; j < arr.length; j++) {
	        	if(name.equals(arr[j].firstname)){
	                System.out.println("Enter First name");
	                arr[j].firstname = sc.next();
	                System.out.println("Enter Last name");
	                arr[j].lastname = sc.next();
	                System.out.println("Enter address");
	                arr[j].address = sc.next();
	                System.out.println("Enter city");
	                arr[j].city = sc.next();
	                System.out.println("Enter state");
	                arr[j].state = sc.next();
	                System.out.println("Enter zip code");
	                arr[j].zipcode = sc.nextInt();
	                System.out.println("Enter phone number");
	                arr[j].phonenum = sc.next();
	                System.out.println("Enter email id");
	                arr[j].email = sc.next();
	                System.out.println("Successfully Edited Contact Entry");
	        	}
	    	}
	 }

	 public void deleteContact() {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Enter First Name to delete that entry from Contact Books ");
	    	String name = sc.next();
	    	for (int j=0; j < arr.length; j++) {
	        	if(name.equals(arr[j].firstname)){
	                arr[j]=null;
	        	}
	    	}
	 }

	 
public static void main(String[] args) {

	System.out.println("Welcome To Address Book Program");
	AddressBook ab= new AddressBook();
	Scanner sc = new Scanner(System.in);
	int count = 0;
	while(count == 0)
	{
		System.out.println("Enter Choice: ");
		System.out.println("1. Add Contact ; 2. Edit Contact ; 3. Delete Contact ; 4. Show Contacts 5. Exit: ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			ab.addContact();
			break;
		case 2:
			ab.editContact();
			break;
		case 3:
			ab.deleteContact();
			break;
		case 4:
			ab.showContact();
			break;
		case 5:
			count = 1;
			break;
		default:
			System.out.println("Enter Correct Choice");
			break;
	}
	}
	
}
}
