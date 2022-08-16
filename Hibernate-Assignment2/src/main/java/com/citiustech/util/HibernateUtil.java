package com.citiustech.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    return sf;
		}
}
