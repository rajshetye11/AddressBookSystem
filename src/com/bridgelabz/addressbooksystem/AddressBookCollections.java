package com.bridgelabz.addressbooksystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class AddressBookCollections {
	
	public int i=0;
	public List<ContactAddressBook> cab = new LinkedList<ContactAddressBook>();
	public HashMap<String, String> personCity = new HashMap<String, String>();
    public HashMap<String, String> personState = new HashMap<String, String>();
    public static String PathName = "file.txt";
	
	public void sortByNames()
	{
		List<ContactAddressBook> names = cab.stream().sorted(Comparator.comparing(ContactAddressBook::getFirstname))
				.collect(Collectors.toList());
		names.forEach(System.out::println);
	}
	
	
	public void sortByCityStateZip() {
		System.out.println(" Enter to Sort by 1.city, 2.state, 3.Zipcode");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {

		case 1:
			List<ContactAddressBook> cityList = cab.stream().sorted(Comparator.comparing(ContactAddressBook::getCity))
					.collect(Collectors.toList());
			cityList.forEach(System.out::println);
			break;
		case 2:

			List<ContactAddressBook> stateList = cab.stream().sorted(Comparator.comparing(ContactAddressBook::getState))
					.collect(Collectors.toList());
			stateList.forEach(System.out::println);
			break;
		case 3:
			List<ContactAddressBook> zipcodeList = cab.stream().sorted(Comparator.comparing(ContactAddressBook::getZipcode))
					.collect(Collectors.toList());
			zipcodeList.forEach(System.out::println);
			break;
		default:
			System.out.println("Please Choose Correct Number");
			break;
		}
	}
    
	public int checkDuplicate(String firstname) {
		ArrayList<String> cDuplicate = new ArrayList<String>();
		for (int i=0;i<cab.size();i++) {
//			if(firstname.equals(cab.get(i).firstname)) {
//				return 1;
//			}
			cDuplicate.add(cab.get(i).firstname);
		}
		
		if (cDuplicate.stream().anyMatch(n -> firstname.equals(n))) return 1;
			return 0;
	}
	
	public void searchCity() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter City: ");
		String cityName = sc.nextLine();
		
//		for(int i =0;i<cab.size();i++) {
//			if(cityName.equals(cab.get(i).city)) {
//				System.out.println(cab.get(i).firstname);
//			}
//		}			
		
		cab.stream().forEach(n -> {
			for(int i =0;i<cab.size();i++) {
				if(cab.get(i).city.equals(cityName)) System.out.println(cab.get(i).firstname);
			}
		});
	}
	
	
	public void searchState() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter state: ");
		String stateName = sc.nextLine();
		
//		for(int i =0;i<cab.size();i++) {
//			if(stateName.equals(cab.get(i).state)) {
//				System.out.println(cab.get(i).firstname);
//			}
//		}
		
		cab.stream().forEach(n -> {
			for(int i =0;i<cab.size();i++) {
				if(cab.get(i).state.equals(stateName))
					{
						System.out.println(cab.get(i).firstname);
					}
			}
		});
	}
	
	public void countPersons() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter State Name");
		String stet = sc.nextLine();
					
		Map<String, Long> count1 = personState.values().stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
		count1.keySet().stream().forEach(n->{
			System.out.println(count1.get(n));
		});
		}

	
	public void viewPersons() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter City or State: ");
		String city = sc.nextLine();
		System.out.println("For City 1 and 2 for state");
		int state = sc.nextInt();
		
		if(state == 1){
//			for(int i =0;i<cab.size();i++) {
//				if(city.equals(cab.get(i).city)) {
//					System.out.println(cab.get(i).firstname);
//				}
//			}
			cab.stream().forEach(n->{
				for(int i =0;i<cab.size();i++) {
					if(cab.get(i).city.equals(city))
						{
							System.out.println(cab.get(i).firstname);
						}
				}
			});
		}else {
//			for(int i =0;i<cab.size();i++) {
//				if(city.equals(cab.get(i).state)) {
//					System.out.println(cab.get(i).firstname);
//				}
//			}
//			
			cab.stream().forEach(n->{
				for(int i =0;i<cab.size();i++) {
					if(cab.get(i).state.equals(city))
						{
							System.out.println(cab.get(i).firstname);
						}
				}
			});
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
		String value1 = firstname+ " " + lastname;
		personCity.put(value1, city);
        personState.put(value1, state);
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

	 
	 public void writeAddressBookData(IOService IOService) {
			if (IOService.equals(IOService.CONSOLE_IO)) {
				System.out.println(cab);
			} else if (IOService.equals(IOService.FILE_IO)) {

				new AddressBookIOService().writeData(cab);
			}
		}

	 public void readFile(Scanner sc,AddressBookCollections addressbook)  {
			
			System.out.println("Enter First Name");
			String firstname = sc.next();

			System.out.println("Enter Last Name");
			String lastname = sc.next();

			System.out.println("Enter Address");
			String address = sc.next();

			System.out.println("Enter City");
			String city = sc.next();

			System.out.println("Enter State");
			String state = sc.next();

			System.out.println("Enter Zip");
			int zipcode = sc.nextInt();

			System.out.println("Enter Phone number");
			String phonenum = sc.next();

			System.out.println("Enter EmailId");
			String email = sc.next();

			ContactAddressBook addressBookCollections = new ContactAddressBook(firstname,lastname,address,city,state,zipcode,phonenum,email);
			cab.add(addressBookCollections);

		}
	 
	 
public static void main(String[] args) {

	System.out.println("Welcome To Address Book Program");
	AddressBookCollections ab= new AddressBookCollections();
	Scanner sc = new Scanner(System.in);
	int count = 0;
	while(count == 0)
	{
		System.out.println("Enter Choice: ");
		System.out.println("1. Add Contact , 2. Edit Contact , 3. Delete Contact , 4. Show Contacts , 5. Search By City  , 6. Search By State ,  7. View Persons  ,8. Count Persons, 9. Sort By Names , 10. Sort By City , State Or Zip  , 11. Read File   12 Write File  13. Exit");
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
		case 7 : 
			ab.viewPersons();
			break;
		case 8: 
			ab.countPersons();
			break;
		case 9:
			ab.sortByNames();
			break;
		case 10:
			ab.sortByCityStateZip();
			break;
		case 11 :
			ab.readFile(sc, ab);
			break;
		case 12 :
			ab.writeAddressBookData(IOService.CONSOLE_IO);
			break;
		case 13: 
			count = 1;
			break;
		default:
			System.out.println("Enter Correct Choice");
			break;
	}
	}
	
}
}