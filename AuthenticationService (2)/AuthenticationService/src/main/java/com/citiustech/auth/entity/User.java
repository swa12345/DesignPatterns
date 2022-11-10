package com.citiustech.auth.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "contact_number")
	private long contactNumber;
	
	@Column(name = "date_of_birth")
	private LocalDate dob;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "wrong_pass_count")
	private int wrongPasswordCount;
	
	@Column(name = "is_default_password")
	private boolean isDefaultPassword;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "modified_date")
	private LocalDate modifiedDate;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = Specialization.class)
	@JoinColumn(name = "specializationId")
	private Specialization specialization;
	
	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = Role.class)
	@JoinColumn(name = "roleId")
	private Role role;
	
	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = Status.class)
	@JoinColumn(name = "statusId")
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

	public User(int userId, String title, String firstName, String lastName, String emailId, long contactNumber,
			LocalDate dob, String password, int wrongPasswordCount, boolean isDefaultPassword, LocalDate createdDate,
			String createdBy, LocalDate modifiedDate, String modifiedBy, Specialization specialization, Role role,
			Status status) {
		super();
		this.userId = userId;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.dob = dob;
		this.password = password;
		this.wrongPasswordCount = wrongPasswordCount;
		this.isDefaultPassword = isDefaultPassword;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.specialization = specialization;
		this.role = role;
		this.status = status;
	}

	public User() {
		super();
		
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", contactNumber=" + contactNumber + ", dob=" + dob + ", password="
				+ password + ", wrongPasswordCount=" + wrongPasswordCount + ", isDefaultPassword=" + isDefaultPassword
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", modifiedDate=" + modifiedDate
				+ ", modifiedBy=" + modifiedBy + ", specialization=" + specialization + ", role=" + role + ", status="
				+ status + "]";
	}
	
	public User(int userId, Role role) {
		this.userId = userId;
		this.role = role;
	}
	
	
}
