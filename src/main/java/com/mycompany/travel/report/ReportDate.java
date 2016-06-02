package com.mycompany.travel.report;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ReportDate {
	private LocalDate date;
	private Long count;
	private Double sum;

	public ReportDate() {

	}

	public ReportDate(int year, int month, int dayOfMonth, Long count, Double sum) {
		date = LocalDate.of(year, month, dayOfMonth);
		this.count = count;
		this.sum = sum;
	}

	public Date asDate(LocalDate date) {
		return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

}
