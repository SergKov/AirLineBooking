package com.mycompany.travel.exception;

public class UserExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6811466879104464429L;

	public UserExistsException(String msg) {
		super(msg);
	}
}
