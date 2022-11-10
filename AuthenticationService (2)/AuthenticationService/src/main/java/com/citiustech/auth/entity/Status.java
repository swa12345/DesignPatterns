package com.citiustech.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private int statusId;
	
	@Column(name = "code")
	private String code;

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", code=" + code + "]";
	}

	public Status() {
		super();
	}

	public Status(int statusId, String code) {
		super();
		this.statusId = statusId;
		this.code = code;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
