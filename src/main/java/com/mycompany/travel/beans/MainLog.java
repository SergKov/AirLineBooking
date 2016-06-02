package com.mycompany.travel.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainLog {
	private static final Logger log = LogManager.getLogger();

	public static void main(String[] args) {
		AccountBean obj = new AccountBean();
		obj.callLogging();
		if (log.isDebugEnabled())
			log.debug("Debug message from a main method");
		try {
			obj.callException();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

}
