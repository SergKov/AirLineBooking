package com.mycompany.travel.dao;

import java.time.LocalDate;
import java.util.List;

import com.mycompany.travel.domain.Ticket;
import com.mycompany.travel.report.ReportDate;
import com.mycompany.travel.report.ReportPlace;

public interface TicketDao {
	public Ticket findById(Integer id);

	public List<ReportDate> getReportByDate(LocalDate from, LocalDate to);

	public List<ReportPlace> getReportByPlace(LocalDate from, LocalDate to);
}
