package com.citiustech.exceptions;

public class InvalidShowTimeException extends RuntimeException {
	
	private static final long serialVersionUID= 1L;
	
	public InvalidShowTimeException(String msg) {
		super(msg);
	}

}
