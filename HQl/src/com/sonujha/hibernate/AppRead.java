package com.sonujha.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sonujha.hibernate.entity.Users;

public class AppRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
															.addAnnotatedClass(Users.class)
															.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Users user = new Users();
			//begin transaction
			session.beginTransaction();
			//Getting the user
			user = session.get(Users.class, 4);
			
			//commit
			session.getTransaction().commit();
			
			System.out.println(user);
			
			
		} finally {
			// TODO: handle finally clause
			factory.close();
			session.close();
		}
		
	}

}
