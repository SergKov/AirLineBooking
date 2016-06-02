package com.mycompany.travel.domain;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "Ord")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "statusOrder")
	private StatusOrder statusOrder;
	private Timestamp modifyDateTime;
	private String telephone;
	private String email;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<Ticket> tickets;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Order() {

	}

	@Transient
	public double getSum() {
		double sum = 0;
		for (Ticket ticket : tickets) {
			sum += ticket.getPrice();
		}
		return sum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getModifyDateTime() {
		return modifyDateTime;
	}

	public void setModifyDateTime(Timestamp modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	public Collection<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Collection<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public StatusOrder getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(StatusOrder statusOrder) {
		this.statusOrder = statusOrder;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
