package com.sonujha.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sonujha.hibernate.entity.Users;

public class AppDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Users.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Users user = new Users();
			//Begin transaction
			session.beginTransaction();
			//get the user
			user = session.get(Users.class, 2);
			//delete the user
			session.delete(user);
			
			//commit the changes
			session.getTransaction().commit();
			System.out.println("Deleted...");
			
		} finally {
			// close all the open
			session.close();
			factory.close();
		}
		
	}

}
