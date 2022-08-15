package com.citiustech.exceptions;

public class UnknownShowException extends RuntimeException {
	
	private static final long serialVersionUID= 1L;
	
	public UnknownShowException(String msg) {
		super(msg);
	}

}
