package com.mycompany.travel.beans;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.context.annotation.Scope;

import com.mycompany.travel.report.ReportDate;
import com.mycompany.travel.report.ReportPlace;
import com.mycompany.travel.service.TicketService;

@Named
@Scope("request")
public class ReportBean {
	private List<ReportDate> reportDate;
	private List<ReportPlace> reportPlace;
	@Inject
	private TicketService ticketService;
	private LineChartModel animatedModel1;
	private LineChartModel animatedModel2;
	private PieChartModel pieModel1;
	private PieChartModel pieModel2;
	private Date from;
	private Date to;

	public ReportBean() {

	}

	public String getReportByDate() {
		reportDate = ticketService.getReportByDate(from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		if (reportDate != null) {
			createLineModels();
		}
		return "ReportByDate";
	}

	public String getReportByPlace() {
		reportPlace = ticketService.getReportByPlace(from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		if (reportPlace != null) {
			createPieModel();
		}
		return "ReportByPlace";
	}

	private void createLineModels() {
		animatedModel1 = initLinearModel1();
		animatedModel1.setTitle("Report");
		animatedModel1.setAnimate(true);
		animatedModel1.setLegendPosition("se");

		animatedModel2 = initLinearModel2();
		animatedModel2.setTitle("Report");
		animatedModel2.setAnimate(true);
		animatedModel2.setLegendPosition("ne");

		Axis yAxis = animatedModel1.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(20);
		yAxis.setTickFormat("%d");

		Axis yAxis2 = animatedModel2.getAxis(AxisType.Y);
		yAxis2.setMin(0);
		yAxis2.setMax(600);

		DateAxis axis = new DateAxis("Dates");
		axis.setTickAngle(-50);
		LocalDate maxDate = LocalDate.now().plusDays(2);
		axis.setMax(maxDate.toString());
		axis.setTickFormat("%b %#d, %y");

		animatedModel1.getAxes().put(AxisType.X, axis);
		animatedModel2.getAxes().put(AxisType.X, axis);
	}

	private LineChartModel initLinearModel1() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Report by Count");

		for (ReportDate report : reportDate) {
			series1.set(report.getDate().toString(), report.getCount());
		}

		model.addSeries(series1);

		return model;
	}

	private LineChartModel initLinearModel2() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series = new LineChartSeries();
		series.setLabel("Report by Sum");

		for (ReportDate report : reportDate) {
			series.set(report.getDate().toString(), report.getSum());
		}
		model.addSeries(series);
		return model;
	}

	private void createPieModel() {
		pieModel1 = new PieChartModel();
		pieModel2 = new PieChartModel();

		for (ReportPlace report : reportPlace) {
			pieModel1.set(report.getLeavingFrom() + " " + report.getGoingTo(), report.getCount());
			pieModel2.set(report.getLeavingFrom() + " " + report.getGoingTo(), report.getSum());
		}

		pieModel1.setTitle("Report By Count");
		pieModel1.setLegendPosition("se");
		pieModel2.setTitle("Report By Sum");
		pieModel2.setLegendPosition("ne");
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public LineChartModel getAnimatedModel1() {
		return animatedModel1;
	}

	public void setAnimatedModel1(LineChartModel animatedModel1) {
		this.animatedModel1 = animatedModel1;
	}

	public LineChartModel getAnimatedModel2() {
		return animatedModel2;
	}

	public void setAnimatedModel2(LineChartModel animatedModel2) {
		this.animatedModel2 = animatedModel2;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public List<ReportDate> getReportDate() {
		return reportDate;
	}

	public void setReportDate(List<ReportDate> reportDate) {
		this.reportDate = reportDate;
	}

	public List<ReportPlace> getReportPlace() {
		return reportPlace;
	}

	public void setReportPlace(List<ReportPlace> reportPlace) {
		this.reportPlace = reportPlace;
	}

}
