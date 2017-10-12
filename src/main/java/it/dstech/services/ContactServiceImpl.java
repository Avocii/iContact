package it.dstech.services;

import java.util.List;

import it.dstech.dao.ContactDao;
import it.dstech.dao.ContactDaoImpl;
import it.dstech.models.Contact;
import it.dstech.models.User;

public class ContactServiceImpl implements ContactService{

	ContactDao contactDao = new ContactDaoImpl();
	
	@Override
	public Contact saveContact(Contact contact) {
		return contactDao.saveContact(contact);
	}

	@Override
	public Contact getContactById(int id) {
		return contactDao.getContactById(id);
	}

	@Override
	public List<Contact> getListContact() {
		return contactDao.getListContact();
	}

	@Override
	public Contact updateContact(Contact contact) {
		return contactDao.updateContact(contact);
	}

	@Override
	public Contact deleteContactById(int id) {
		return contactDao.deleteContactById(id);
	}

	@Override
	public List<Contact> getListContactByUser(User user) {
		return contactDao.getListContactByUser(user);
	}

}
