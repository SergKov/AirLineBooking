package com.mycompany.travel.exception;

public class FlightHasPassengersException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5019542976278791020L;

	public FlightHasPassengersException(String msgs) {
		super(msgs);
	}

}
