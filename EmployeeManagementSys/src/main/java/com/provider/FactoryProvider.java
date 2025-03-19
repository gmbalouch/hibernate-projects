package com.provider;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	private static SessionFactory sessionFactory;

	static {
		try {
			if(sessionFactory==null) {
				sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
			
		}catch(Exception e) {
			throw new RuntimeException("Error in creating session factory"+e.getMessage());
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
