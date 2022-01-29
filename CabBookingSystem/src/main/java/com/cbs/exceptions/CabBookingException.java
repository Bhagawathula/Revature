package com.cbs.exceptions;

public class CabBookingException extends Exception {

	public CabBookingException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "Cabs are not available right now.\nPlease try after sometime.";
	}

	@Override
	public String getMessage() {
		return "Cabs are booked";
	}

}
