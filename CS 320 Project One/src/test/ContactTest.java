package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.model.Contact;

class ContactTest {
	
	@Test
	void contactTest() {
		Contact contact = new Contact("123456789", "Joe", "Smith", "8605991234", "25 Main Street");
		assertTrue(contact.getContactID() == "123456789");
		assertTrue(contact.getFirstName() == "Joe");
		assertTrue(contact.getLastName() == "Smith");
		assertTrue(contact.getPhone() == "8605991234");
		assertTrue(contact.getAddress() == "25 Main Street");
	}

	@Test
	void contactIDTooLong() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("12345678910", "Joe", "Smith", "8605991234", "25 Main Street");
		});
	}

	@Test
	void contactIDIsNull() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, "Joe", "Smith", "8605991234", "25 Main Street");
		});
	}

	@Test
	void firstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123456789", "LongFirstName", "Smith", "8605991234", "25 Main Street");
		});
	}

	@Test
	void firstNameIsNull() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123456789", null, "Smith", "8605991234", "25 Main Street");
		});
	}

	@Test
	void lastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123456789", "Joe", "LongLastName", "8605991234", "25 Main Street");
		});
	}

	@Test
	void lastNameIsNull() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123456789", "Joe", null, "8605991234", "25 Main Street");
		});
	}

	@Test
	void phoneWrongLength() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123456789", "Joe", "Smith", "86059912345", "25 Main Street");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123456789", "Joe", "Smith", "860599123", "25 Main Street");
		});
	}

	@Test
	void PhoneIsNull() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123456789", "Joe", "Smith", null, "25 Main Street");
		});
	}
	
	@Test
	void addressTooLong() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123456789", "Joe", "Smith", "8605991234", "12345 Really Long Street Name Avenue");
		});
	}

	@Test
	void addressIsNull() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("123456789", "Joe", "Smith", "8605991234", null);
		});
	}
}
