package com.sonujha.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sonujha.hibernate.entity.Users;

public class AppUpdate {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Users.class)
													.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Users user = new Users();
			//begin transaction
			session.beginTransaction();
			//get the user which is to be updated
			user = session.get(Users.class, 2);
			//Update it
			user.setUsername("Raj");
			
			//Commit the changes
			session.getTransaction().commit();
			System.out.println(user);
			
		} finally {
			// TODO: handle finally clause
			factory.close();
			session.close();
		}
		
	}

}
