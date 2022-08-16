package com.citiustech.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Locker {

	@Id
	private String LockerId;
	private String LockerType;
	private int Rent;
	
	public Locker() {
		super();
	}
	
	public Locker(String lockerId, String lockerType, int rent) {
		super();
		LockerId = lockerId;
		LockerType = lockerType;
		Rent = rent;
	}
	
	public String getLockerId() {
		return LockerId;
	}
	public void setLockerId(String lockerId) {
		LockerId = lockerId;
	}
	public String getLockerType() {
		return LockerType;
	}
	public void setLockerType(String lockerType) {
		LockerType = lockerType;
	}
	public int getRent() {
		return Rent;
	}
	public void setRent(int rent) {
		Rent = rent;
	}
	@Override
	public String toString() {
		return "Locker [LockerId=" + LockerId + ", LockerType=" + LockerType + ", Rent=" + Rent + "]";
	}
	
}
