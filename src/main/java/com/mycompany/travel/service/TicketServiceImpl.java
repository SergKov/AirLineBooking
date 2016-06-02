package com.mycompany.travel.service;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.mycompany.travel.dao.TicketDao;
import com.mycompany.travel.domain.Ticket;
import com.mycompany.travel.report.ReportDate;
import com.mycompany.travel.report.ReportPlace;

@Named
public class TicketServiceImpl implements TicketService {
	@Inject
	private TicketDao ticketDao;

	@Override
	public Ticket findById(Integer id) {
		return ticketDao.findById(id);
	}

	@Override
	public List<ReportDate> getReportByDate(LocalDate from, LocalDate to) {
		return ticketDao.getReportByDate(from, to);
	}

	@Override
	public List<ReportPlace> getReportByPlace(LocalDate from, LocalDate to) {
		return ticketDao.getReportByPlace(from, to);
	}

}
