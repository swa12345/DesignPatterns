package com.citiustech.auth.dto;

import java.time.LocalDate;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.citiustech.auth.entity.Role;
import com.citiustech.auth.entity.Specialization;
import com.citiustech.auth.entity.Status;

public class UserDTO {

private int userId;
	
	private String title;
	private String firstName;
	private String lastName;
	private String emailId;
	private long contactNumber;
	private LocalDate dob;
	private String password;
	private int wrongPasswordCount;
	private boolean isDefaultPassword;
	private LocalDate createdDate;
	private String createdBy;
	private LocalDate modifiedDate;
	private String modifiedBy;
	private Specialization specialization;
	private Role role;
	private Status status;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		//this.password = BCrypt.hashpw(password, BCrypt.gensalt());
		this.password = password;
	}
	public int getWrongPasswordCount() {
		return wrongPasswordCount;
	}
	public void setWrongPasswordCount(int wrongPasswordCount) {
		this.wrongPasswordCount = wrongPasswordCount;
	}
	public boolean isDefaultPassword() {
		return isDefaultPassword;
	}
	public void setDefaultPassword(boolean isDefaultPassword) {
		this.isDefaultPassword = isDefaultPassword;
	}
	public LocalDate getCreatedDate() {
		return LocalDate.now();
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getModifiedDate() {
		return LocalDate.now();
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
