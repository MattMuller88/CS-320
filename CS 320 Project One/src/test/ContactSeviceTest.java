package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.model.Contact;
import main.java.model.ContactService;



class ContactSeviceTest {

	@Test
	void addContactTest() {
		ContactService service = new ContactService();
		service.addContact("123456789", "Joe", "Smith", "8605991234", "25 Main Street");
		List<Contact> list = service.getContactList();
		boolean test = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getContactID() == "123456789") {
				test = true;
			}
		}
		assertTrue(test);
	}
	
	@Test
	void addDuplicateTest() {
		ContactService service = new ContactService();
		service.addContact("123456789", "Joe", "Smith", "8605991234", "25 Main Street");
		assertThrows(IllegalArgumentException.class, () ->{
			service.addContact("123456789", "Mike", "Jones", "4015554321", "22 Elm Street");
		});
	}

	@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.addContact("123456789", "Joe", "Smith", "8605991234", "25 Main Street");
		boolean test = false;
		for (int i = 0; i < service.getContactList().size(); i++) {
			if (service.getContactList().get(i).getContactID() == "123456789") {
				test = true;
			}
		}
		assertTrue(test);
		service.deleteContact("123456789");
		test = false;
		for (int i = 0; i < service.getContactList().size(); i++) {
			if (service.getContactList().get(i).getContactID() == "123456789") {
				test = true;
			}
		}
		assertFalse(test);
	}
	
	@Test
	void updateContactTest() {
		ContactService service = new ContactService();
		service.addContact("123456789", "Joe", "Smith", "8605991234", "25 Main Street");
		service.updateContact("123456789", "Mike", "Jones", "4015554321", "22 Elm Street");
		boolean test = false;
		for (int i = 0; i < service.getContactList().size(); i++) {
			if (service.getContactList().get(i).getContactID() == "123456789") {
				if(service.getContactList().get(i).getFirstName() == "Mike" && service.getContactList().get(i).getLastName() == "Jones" && service.getContactList().get(i).getPhone() == "4015554321" && service.getContactList().get(i).getAddress() == "22 Elm Street") {
					test = true;
			}
		}
		}
		assertTrue(test);
	}
}
