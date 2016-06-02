package com.mycompany.travel.beans;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.mycompany.travel.domain.Flight;
import com.mycompany.travel.domain.Ticket;

@Named
@ViewScoped
public class TicketCreationBean {
	private Ticket ticket;

	public TicketCreationBean() {

	}

	public String initTicketCreation(Flight flight) {
		ticket = new Ticket();
		ticket.setFlight(flight);
		ticket.setPrice(flight.getPrice());
		return "addTicket";
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
