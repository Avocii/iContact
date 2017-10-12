package it.dstech.dao;

import java.util.List;

import it.dstech.models.Contact;
import it.dstech.models.User;

public interface ContactDao {

	Contact saveContact(Contact contact);

	Contact getContactById(int id);

	List<Contact> getListContact();

	Contact updateContact(Contact contact);

	Contact deleteContactById(int id);
	
	List<Contact> getListContactByUser(User user);

}
