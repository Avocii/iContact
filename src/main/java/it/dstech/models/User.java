package it.dstech.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;

	@Column(unique=true)
	private String username;
	
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Contact> listaContatti;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		listaContatti = new ArrayList<Contact>();
	}

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Contact> getListaContatti() {
		return listaContatti;
	}

	public void setListaContatti(List<Contact> listaContatti) {
		this.listaContatti = listaContatti;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
