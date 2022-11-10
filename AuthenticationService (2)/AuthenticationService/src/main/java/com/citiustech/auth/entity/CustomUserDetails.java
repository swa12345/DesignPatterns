package com.citiustech.auth.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Object principal;

	Object credentials;

	String role;

	public CustomUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomUserDetails(Object principal, Object credentials, String role) {
		super();
		this.principal = principal;
		this.credentials = credentials;
		this.role = role;
	}

	public Object getPrincipal() {
		return principal;
	}

	public void setPrincipal(Object principal) {
		this.principal = principal;
	}

	public Object getCredentials() {
		return credentials;
	}

	public void setCredentials(Object credentials) {
		this.credentials = credentials;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomUserDetails [principal=" + principal + ", credentials=" + credentials + ", role=" + role + "]";
	}
	
	
}
