package com.citiustech.Hibernate_Assignment2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.model.Customer;
import com.citiustech.model.Locker;
import com.citiustech.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Customer customer = new Customer();
//        customer.setCustomerId(7004);
//        customer.setCustomerName("William11");
//        customer.setDateOfBirth("17-05-1995");
//        customer.setAddress("Kolkata");
//        customer.setPhoneNo(906774);
//        
//        Locker lock = new Locker();
//        lock.setLockerId("LOC1");
//        lock.setLockerType("Small");
//        lock.setRent(1100);
        
//        customer.setLocker(lock);
//        customer.setLocker(lock1);
        session.beginTransaction();
//        session.save(customer);
        Customer c=  (Customer) session.load(Customer.class, 7001);
        c.getLocker().setRent(1200);;

        session.getTransaction().commit();
        session.close();
        
    }
}
