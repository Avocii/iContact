package it.dstech.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contact {

	@Id
	@GeneratedValue
	private int id;

	String name;
	
	String cognome;

	String tel;

	String mail;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Contact_ID")
	User user;

	public Contact(String name, String cognome, String tel, String mail) {
		this.name = name;
		this.tel = tel;
		this.mail = mail;
	}

	public Contact() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", tel=" + tel + ", mail=" + mail + ", user=" + user + "]";
	}

}
