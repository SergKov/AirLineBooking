package com.mycompany.travel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer id;

	private String login;
	private String password;
	private String name;
	private String surName;
	private String middleName;

	@Enumerated(EnumType.STRING)
	private PositionEmployee position;

	@Enumerated(EnumType.STRING)
	private StatusEmployee status;

	private String email;
	private String telephoneOne;
	private String telephoneTwo;

	public Employee() {

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public PositionEmployee getPosition() {
		return position;
	}

	public void setPosition(PositionEmployee position) {
		this.position = position;
	}

	public StatusEmployee getStatus() {
		return status;
	}

	public void setStatus(StatusEmployee status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", login=" + login + ", password=" + password + ", name=" + name + ", surName="
				+ surName + ", middleName=" + middleName + ", position=" + position + ", status=" + status + ", email="
				+ email + ", telephoneOne=" + telephoneOne + ", telephoneTwo=" + telephoneTwo + "]";
	}

}
