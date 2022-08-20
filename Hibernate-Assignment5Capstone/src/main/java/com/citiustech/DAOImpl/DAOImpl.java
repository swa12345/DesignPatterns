package com.citiustech.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.DAO.DAO;
import com.citiustech.model.Assets;
import com.citiustech.model.Employee;
import com.citiustech.util.HibernateUtil;

public class DAOImpl implements DAO {
	
	SessionFactory sf= HibernateUtil.getSessionFactory();
	Session session = sf.openSession();

	public void addEmployee(Employee e) {
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		System.out.println("Employee has been Added whose Employee id is "+e.getEmpId());
		
	}

	public void getAssetDetails(int assetId) {
//		Query assetDetails = session.createQuery("from Assets a where a.assetId=:aid");
//		assetDetails.setLong("aid", assetId);
//		List<Assets> assetsList = assetDetails.list();
		Assets assetDetails = (Assets) session.load(Assets.class, assetId);

		System.out.println("Asset Details : \n"+assetDetails.getAssetId()+" "+assetDetails.getAssetLocation()+" "+assetDetails.getAssetPrice()+" "+assetDetails.getAssetType()+" "+assetDetails.getPrNo()+" "+assetDetails.getSerialNo());
		
	}

	public void getAssetWithMaxPrice() {
		Query assetPriceMax = session.createQuery("from Assets order by assetPrice desc");
		 Assets a =  (Assets) assetPriceMax.list().get(0);
		 System.out.println("Assets Details with Max Price \n"+a);
		
	}

	public void totalEmployeesCount() {
		Query totalEmployees = session.createQuery("select count(empId) from Employee");
		List<Integer> count = totalEmployees.list();
		System.out.println("Total No of Employees are : "+count.get(0));
		
	}

	public void getEmployeeDetails() {
		Query employeeDetails = session.createQuery("from Employee order by empName asc");
		List<Employee> empDetails = employeeDetails.list();
		for(Employee e:empDetails) {
			System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getPassword()+" "+e.getAsset());
		}
		
	}

	public void getEmployeeAndAssetDetails(int empId) {
		Query employeeDetails = session.createQuery("from Employee where empId=:eid");
		employeeDetails.setLong("eid", empId);
		List<Employee> empDetails = employeeDetails.list();
		for(Employee e:empDetails) {
			System.out.println(e.getEmpId()+" "+e.getEmpName()+" "+e.getPassword()+" "+e.getAsset());
		}
		
	}

	public void updatePassword(int empId,String newPassword) {
		session.beginTransaction();
		Query updatePassword = session.createQuery("update Employee e set e.password=:newPassword where e.empId=:empId");
		updatePassword.setParameter("newPassword", newPassword);
		updatePassword.setParameter("empId", empId);
		updatePassword.executeUpdate();
		session.getTransaction().commit();
		System.out.println("Employee Password has been Updated "+updatePassword.list());
		
	}

	public void deleteEmployeeAndAssetDetails(int empId) {
		session.beginTransaction();
		Query deleteEmpAssetDetails = session.createQuery("delete from Employee e where e.empId=:eId");
		deleteEmpAssetDetails.setParameter("eId", empId);
		deleteEmpAssetDetails.executeUpdate();
		session.getTransaction().commit();
	}
	
	
}
