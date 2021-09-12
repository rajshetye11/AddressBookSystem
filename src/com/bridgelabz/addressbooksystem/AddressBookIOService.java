package com.bridgelabz.addressbooksystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookIOService {
	public static String ADDRESSBOOK_FILE_NAME="addressBook-file.txt";
	
	public void writeData(List<ContactAddressBook> addressBookList) {
	StringBuffer addressBookBuffer=new StringBuffer();
	addressBookList.forEach(addressBook->{
		String addressBookDataString =addressBook.toString().concat("\n");
		addressBookBuffer.append(addressBookDataString);
	});
		try {
			Files.write(Paths.get(ADDRESSBOOK_FILE_NAME),addressBookBuffer.toString().getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void printData() {
	  
		try {
			Files.lines(new File("addressBook-file.txt").toPath())
			.forEach(System.out::println);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}