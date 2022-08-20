package com.citiustech.DAO;

import com.citiustech.model.Assets;
import com.citiustech.model.Employee;

public interface DAO {
	public void addEmployee(Employee e);
	public void getAssetDetails(int assetId);
	public void getAssetWithMaxPrice();
	public void totalEmployeesCount();
	public void getEmployeeDetails();
	public void getEmployeeAndAssetDetails(int empId);
	public void updatePassword(int empId,String newPassword);
	public void deleteEmployeeAndAssetDetails(int empId);
}