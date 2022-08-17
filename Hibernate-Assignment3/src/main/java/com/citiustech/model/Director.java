package com.citiustech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="director")
public class Director {

	@Id
	private int directorId;
	@Column(name="directorname")
	private String directorName;
	@Column(name="bornin")
	private int bornIn;
	
	public Director() {
		super();
	}
	public Director(int directorId, String directorName, int bornIn) {
		super();
		this.directorId = directorId;
		this.directorName = directorName;
		this.bornIn = bornIn;
	}
	public int getDirectorId() {
		return directorId;
	}
	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public int getBornIn() {
		return bornIn;
	}
	public void setBornIn(int bornIn) {
		this.bornIn = bornIn;
	}
	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", directorName=" + directorName + ", bornIn=" + bornIn + "]";
	}
	
	
}
