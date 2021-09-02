package com.bridgelabz.addressbooksystem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class AddressBookCollections {
	
	public int i=0;
	public LinkedList<ContactAddressBook> cab = new LinkedList<ContactAddressBook>();
	
	
	public int checkDuplicate(String firstname) {
		for (int i=0;i<cab.size();i++) {
			if(firstname.equals(cab.get(i).firstname)) {
				return 1;
			}
		}
		return 0;
	}
	
	public void searchCity() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter City: ");
		String city = sc.nextLine();
		
		for(int i =0;i<cab.size();i++) {
			if(city.equals(cab.get(i).city)) {
				System.out.println(cab.get(i).firstname);
			}
		}
	}
	
	
	public void searchState() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter state: ");
		String state = sc.nextLine();
		
		for(int i =0;i<cab.size();i++) {
			if(state.equals(cab.get(i).state)) {
				System.out.println(cab.get(i).firstname);
			}
		}
	}
	public void addContact() 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of entries: ");
		int record = sc.nextInt();
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
		
		if(checkDuplicate(firstname)== 1) {
			System.out.println("Sorry Name Already Exits");
		}else {
		ContactAddressBook addressBookCollections = new ContactAddressBook(firstname,lastname,address,city,state,zipcode,phonenum,email);
		cab.add(addressBookCollections);
		System.out.println("Contact created Successfully");
	}	}
}
	
	
	
	
	 public void showContact(){
	      	for (int i=0; i < cab.size(); i++) {
	      		System.out.println(cab.get(i));
	      	}
	      }
	
	 public void editContact() {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Enter First Name to edit that entry from Contact Books ");
	    	String name = sc.next();
	    	for (int j=0; j < cab.size(); j++) {
	        	if(name.equals(cab.get(j).firstname)){
	                System.out.println("Enter First name");
	                cab.get(j).firstname = sc.next();
	                System.out.println("Enter Last name");
	                cab.get(j).lastname = sc.next();
	                System.out.println("Enter address");
	                cab.get(j).address = sc.next();
	                System.out.println("Enter city");
	                cab.get(j).city = sc.next();
	                System.out.println("Enter state");
	                cab.get(j).state = sc.next();
	                System.out.println("Enter zip code");
	                cab.get(j).zipcode = sc.nextInt();
	                System.out.println("Enter phone number");
	                cab.get(j).phonenum = sc.next();
	                System.out.println("Enter email id");
	                cab.get(j).email = sc.next();
	                System.out.println("Successfully Edited Contact Entry");
	        	}
	    	}
	 }

	 public void deleteContact() {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Enter First Name to delete that entry from Contact Books ");
	    	String name = sc.next();
	    	for (int j=0; j < cab.size(); j++) {
	        	if(name.equals(cab.get(j).firstname)){
	        		cab.remove(j);
	        	}
	    	}
	 }

	 
public static void main(String[] args) {

	System.out.println("Welcome To Address Book Program");
	AddressBookCollections ab= new AddressBookCollections();
	Scanner sc = new Scanner(System.in);
	int count = 0;
	while(count == 0)
	{
		System.out.println("Enter Choice: ");
		System.out.println("1. Add Contact , 2. Edit Contact , 3. Delete Contact , 4. Show Contacts , 5. Search By City  , 6. Search By State ,  7. Exit");
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
			ab.searchCity();
			break;
		case 6:
			ab.searchState();
			break;
		case 7:
			count = 1;
			break;
		default:
			System.out.println("Enter Correct Choice");
			break;
	}
	}
	
}
}
