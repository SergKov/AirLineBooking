package com.mycompany.travel.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;
	private String login;
	private String password;
	private String email;
	private String telephoneOne;
	private String telephoneTwo;

	@OneToMany(mappedBy = "customer")
	private Collection<Order> orders;

	public Customer() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneOne() {
		return telephoneOne;
	}

	public void setTelephoneOne(String telephoneOne) {
		this.telephoneOne = telephoneOne;
	}

	public String getTelephoneTwo() {
		return telephoneTwo;
	}

	public void setTelephoneTwo(String telephoneTwo) {
		this.telephoneTwo = telephoneTwo;
	}

	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}

}
