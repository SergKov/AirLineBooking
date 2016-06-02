package com.mycompany.travel.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_id")
	private Integer id;
	private String flightNumber;
	private String leavingFrom;
	private String goingTo;
	private Timestamp departureDateTime;
	private Timestamp arrivalInDateTime;
	private Double price;
	private Integer maxPassengers;
	private Integer passengersAvailable;

	public Flight() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getLeavingFrom() {
		return leavingFrom;
	}

	public void setLeavingFrom(String leavingFrom) {
		this.leavingFrom = leavingFrom;
	}

	public String getGoingTo() {
		return goingTo;
	}

	public void setGoingTo(String goingTo) {
		this.goingTo = goingTo;
	}

	public Timestamp getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(Timestamp departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public Timestamp getArrivalInDateTime() {
		return arrivalInDateTime;
	}

	public void setArrivalInDateTime(Timestamp arrivalInDateTime) {
		this.arrivalInDateTime = arrivalInDateTime;
	}

	public Integer getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(Integer maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public Integer getPassengersAvailable() {
		return passengersAvailable;
	}

	public void setPassengersAvailable(Integer passengersAvailable) {
		this.passengersAvailable = passengersAvailable;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", leavingFrom=" + leavingFrom + ", goingTo="
				+ goingTo + ", departureDateTime=" + departureDateTime + ", arrivalInDateTime=" + arrivalInDateTime
				+ ", price=" + price + ", maxPassengers=" + maxPassengers + ", passengersAvailable="
				+ passengersAvailable + "]";
	}

}
