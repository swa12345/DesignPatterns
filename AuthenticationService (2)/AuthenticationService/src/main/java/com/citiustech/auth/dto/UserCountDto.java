package com.citiustech.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCountDto {

	private Long physicianCount;

	private Long nurseCount;

	private Long patientCount;

	public UserCountDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCountDto(Long physicianCount, Long nurseCount, Long patientCount) {
		super();
		this.physicianCount = physicianCount;
		this.nurseCount = nurseCount;
		this.patientCount = patientCount;
	}

	public Long getPhysicianCount() {
		return physicianCount;
	}

	public void setPhysicianCount(Long physicianCount) {
		this.physicianCount = physicianCount;
	}

	public Long getNurseCount() {
		return nurseCount;
	}

	public void setNurseCount(Long nurseCount) {
		this.nurseCount = nurseCount;
	}

	public Long getPatientCount() {
		return patientCount;
	}

	public void setPatientCount(Long patientCount) {
		this.patientCount = patientCount;
	}

	@Override
	public String toString() {
		return "UserCountDto [physicianCount=" + physicianCount + ", nurseCount=" + nurseCount + ", patientCount="
				+ patientCount + "]";
	}
	
	

}
