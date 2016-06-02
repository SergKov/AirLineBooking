package com.mycompany.travel.exception;

public class NoSuchUserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 779260023906761985L;

	public NoSuchUserException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
