package com.citiustech.auth.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Specialization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "specialization_id")
	
	private int specializationId;
	
	@Column(name = "code")
	private String code;
	

	@Override
	public String toString() {
		return "Specialization [specializationId=" + specializationId + ", code=" + code + "]";
	}

	public Specialization() {
		super();
	}

	public Specialization(int specializationId, String code) {
		super();
		this.specializationId = specializationId;
		this.code = code;
	}

	public int getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
