package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Contact.ContactService;

class ContactServiceTest {
	
	
	//clear the array list after each test
	@AfterEach
	void tearDown() throws Exception {
		ContactService.contactList.clear();
	}

	/**
	 * callAddContact passing the first, last, phone, address then validate it
	 * worked using getters validate that the ArryList is not empty
	 */
	@DisplayName("Run the addContact test")
	@Test
	void testAddContact() {

		String firstName = "Theo";
		String lastName = "Bennett";
		String phoneNumber = "9845257816";
		String address = "345 East Street";

		ContactService test = new ContactService();

		assertTrue(ContactService.contactList.isEmpty());

		test.addContact(firstName, lastName, phoneNumber, address);

		assertFalse(ContactService.contactList.isEmpty());
		assertEquals(0, ContactService.contactList.get(0).getContactID());
		assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
		assertEquals(lastName, ContactService.contactList.get(0).getLastName());
		assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());
		assertEquals(address, ContactService.contactList.get(0).getAddress());

	}
	/**
	* Add 3 contacts via addContact delete object at id 1 check that there is no
	* object there
	*/
	@DisplayName("Run the deleteContact test")			  
	@Test void testDeleteContact() {
				  
		String firstName = "Theo"; 
		String lastName = "Bennett"; 
		String phoneNumber = "9845257816"; 
		String address = "345 East Street";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  
		assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);//object at ID 0
		test.addContact(firstName, lastName, phoneNumber, address);//object at ID 1
		test.addContact(firstName, lastName, phoneNumber, address);//object at ID 2
		  
		assertEquals(3,ContactService.contactList.size());
		  
		test.deleteContact("1");
		  
		assertEquals(2,ContactService.contactList.size());
		 
		//loop through to look for ID
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getContactID() == 1) {
				testBool = true;
			}
		}		
		assertFalse(testBool);				 
	}
	/**
	 * create a contact and then validate the phone number
	 * edit the phone and re validate
	 */
	@DisplayName("Perform a test edit of a phone number")
	@Test
	void testEditPhone() {
		
		String firstName = "345"; 
		String lastName = "Bennett"; 
		String phoneNumber = "9845257816"; 
		String address = "345 East Street";
		  
		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());
		
		test.editNumber("0", "8945789635");
		assertEquals("8945789635", ContactService.contactList.get(0).getPhoneNumber());
	}
	/**
	 * create a contact and then validate the Last name
	 * edit the last name and re validate
	 */
	@DisplayName("Editing a last name")
	@Test
	void testEditLast() {
		
		String firstName = "Theo"; 
		String lastName = "Bennett"; 
		String phoneNumber = "9845257816"; 
		String address = "345 Main Street";
		  
		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(lastName, ContactService.contactList.get(0).getLastName());
		
		test.editLastName("0", "Test_Name");
		assertEquals("Test_Name", ContactService.contactList.get(0).getLastName());
	}
	/**
	 * create a contact and then validate the first name
	 * edit the first name and re validate
	 */
	@DisplayName("Editing a first name")
	@Test
	void testEditFirst() {
		
		String firstName = "Theo"; 
		String lastName = "Bennett"; 
		String phoneNumber = "9845257816"; 
		String address = "345 East Street";

		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
		
		test.editFirstName("0", "Test_First");
		assertEquals("Test_First", ContactService.contactList.get(0).getFirstName());
	}
	/**
	 * create a contact and then validate the address
	 * edit the address and re validate
	 */
	@DisplayName("Editing an address")
	@Test
	void testEditAddress() {
		
		String firstName = "Theo"; 
		String lastName = "Bennett"; 
		String phoneNumber = "9845257816"; 
		String address = "345 Main Street";

		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(address, ContactService.contactList.get(0).getAddress());
		
		test.editAddress("0", "Test_Address");
		assertEquals("Test_Address", ContactService.contactList.get(0).getAddress());
	}
}
