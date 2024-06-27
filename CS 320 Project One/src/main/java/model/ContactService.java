package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
//Declare list to hold Contacts
	private ArrayList<Contact> contactList;
	
//Default constructor
	public ContactService() {
		contactList = new ArrayList<Contact>();
	}
	
//Contact list getter
	public List<Contact> getContactList() {
		return contactList;
	}
	
//Method to create contact with unique ID and add it to contact list
	public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
		boolean unique = true;
		for (int i = 0; i < contactList.size(); i++) {
			if (contactID == contactList.get(i).getContactID()) {
				unique = false;
			}
		}
		if (unique == true) {
			Contact contact = new Contact(contactID, firstName, lastName, phone, address);
			contactList.add(contact);
		}
		else {
			throw new IllegalArgumentException("Duplicate contact ID");
		}
	}
	
//Method to delete contact with provided ID
	public void deleteContact(String id) {
		for (int i = 0; i < contactList.size(); i++) {
			if (id == contactList.get(i).getContactID()) {
				contactList.remove(i);
			}
		}
	}
	
//Method for updating contact fields per contactID
	public void updateContact(String contactID, String newFirstName, String newLastName, String newPhone, String newAddress) {
		boolean search = false;
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getContactID() == contactID) {
				search = true;
				contactList.get(i).setFirstName(newFirstName);
				contactList.get(i).setLastName(newLastName);
				contactList.get(i).setPhone(newPhone);
				contactList.get(i).setAddress(newAddress);
			}
		}
		if(search == false) {
			System.out.println("No Contact exists with given ID.");
		}
	}
}
