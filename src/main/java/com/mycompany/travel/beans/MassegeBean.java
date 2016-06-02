package com.mycompany.travel.beans;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named("msgs")
@Scope("request")
public class MassegeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String startLogin = "Login can't be empty";
	private static final String existLogin = "This login has already existed";
	private static final String incorrectLogin = "Incorrect Login";
	private static final String startPassword = "Password can't be empty";
	private static final String incorrectPassword = "Incorrect Password";
	private static final String repeatPassword = "Wrong repetition";
	private static final String startEmail = "E-mail can't be empty";
	private static final String incorrectEmail = "E-mail isn't correct";
	private static final String startTelephoneNumber = "Telephone's number can't be empty";
	private static final String incorrectTelephoneNumber = "Telephone's number isn't correct";
	private static final String startField = "This field can't be empty";
	private static final String incorrectData = "This field has incorrect data";
	private static final String incorrectName = "Incorrect name";
	private static final String startName = "Name can't be empty";
	private static final String incorrectSurName = "Incorrect surName";
	private static final String startMiddleName = "MiddleName can't be empty";
	private static final String incorrectMiddleName = "Incorrect middleName";
	private static final String startSurName = "SurName can't be empty";
	private static final String startPassport = "Passport can't be empty";
	private static final String incorrectPassport = "Incorrect passport";
	private static final String startDate = "Date can't be empty";
	private static final String startFlightNumber = "Flight Number can't be empty";
	private static final String incorrectFlightNumber = "Incorrect flight number";
	private static final String startPlace = "The place can't be empty";
	private static final String incorrectPlace = "Incorrect place";
	private static final String startTime = "Time can't be empty";
	private static final String startPrice = "Price can't be empty";
	private static final String incorrectPrice = "Incorrect price";

	public MassegeBean() {

	}

	public String getStartLogin() {
		return startLogin;
	}

	public String getStartPassword() {
		return startPassword;
	}

	public String getStartEmail() {
		return startEmail;
	}

	public String getIncorrectEmail() {
		return incorrectEmail;
	}

	public String getIncorrectTelephoneNumber() {
		return incorrectTelephoneNumber;
	}

	public String getExistLogin() {
		return existLogin;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public String getStartTelephoneNumber() {
		return startTelephoneNumber;
	}

	public String getIncorrectLogin() {
		return incorrectLogin;
	}

	public String getIncorrectPassword() {
		return incorrectPassword;
	}

	public String getStartField() {
		return startField;
	}

	public String getIncorrectData() {
		return incorrectData;
	}

	public String getIncorrectName() {
		return incorrectName;
	}

	public String getStartName() {
		return startName;
	}

	public String getIncorrectSurName() {
		return incorrectSurName;
	}

	public String getStartMiddleName() {
		return startMiddleName;
	}

	public String getIncorrectMiddleName() {
		return incorrectMiddleName;
	}

	public String getStartSurName() {
		return startSurName;
	}

	public String getStartPassport() {
		return startPassport;
	}

	public String getIncorrectPassport() {
		return incorrectPassport;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getStartFlightNumber() {
		return startFlightNumber;
	}

	public String getIncorrectFlightNumber() {
		return incorrectFlightNumber;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public String getIncorrectPlace() {
		return incorrectPlace;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getStartPrice() {
		return startPrice;
	}

	public String getIncorrectPrice() {
		return incorrectPrice;
	}

}
