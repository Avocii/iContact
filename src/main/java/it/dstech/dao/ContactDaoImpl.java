package it.dstech.dao;

import java.util.List;

import org.hibernate.Query;

import it.dstech.models.Contact;
import it.dstech.models.User;

public class ContactDaoImpl extends HibernateDao implements ContactDao {

	@Override
	public Contact saveContact(Contact contact) {
		return (Contact) persist(contact);
	}

	@Override
	public Contact getContactById(int id) {
		return (Contact) getById(Contact.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getListContact() {
		return select("SELECT c FROM Contact c").list();
	}

	@Override
	public Contact updateContact(Contact contact) {
		return (Contact) update(contact);
	}

	@Override
	public Contact deleteContactById(int id) {
		return (Contact) delete(getContactById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getListContactByUser(User user) {
		Query query= select("SELECT c.listaContatti FROM User c WHERE c.id=:idUser");
		query.setParameter("idUser", user.getId());
		
		return query.list();
	}

}
