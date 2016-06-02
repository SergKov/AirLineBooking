package com.mycompany.travel.exception;

public class NoFreePlacesException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2400985095747103384L;

	public NoFreePlacesException(String msgs) {
		super(msgs);
	}
}
