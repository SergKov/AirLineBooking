package com.mycompany.travel.report;

public class ReportPlace {
	private String leavingFrom;
	private String goingTo;
	private Long count;
	private Double sum;

	public ReportPlace() {

	}

	public ReportPlace(String leavingFrom, String goingTo, Long count, Double sum) {
		this.leavingFrom = leavingFrom;
		this.goingTo = goingTo;
		this.count = count;
		this.sum = sum;
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
