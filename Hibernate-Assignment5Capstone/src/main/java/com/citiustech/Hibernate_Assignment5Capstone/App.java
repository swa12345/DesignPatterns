package com.citiustech.Hibernate_Assignment5Capstone;

import com.citiustech.DAOImpl.DAOImpl;
import com.citiustech.model.Assets;
import com.citiustech.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
	public static DAOImpl daoImpl = new DAOImpl();
    public static void main( String[] args )
    {
//    	Assets asset1 = new Assets(1042, 105, 2, "Mobile", 89000, "Mumbai");
//    	Employee employee1 = new Employee("Adarsh",104,"adarsh",asset1);
//      daoImpl.addEmployee(employee1);
//    	daoImpl.getAssetDetails(1041);
//    	daoImpl.getAssetWithMaxPrice();
//    	daoImpl.totalEmployeesCount();
//    	daoImpl.getEmployeeDetails();
//    	daoImpl.getEmployeeAndAssetDetails(102);
//    	daoImpl.updatePassword(102, "70284594@131");
    	daoImpl.deleteEmployeeAndAssetDetails(104);
    	
    }
}
