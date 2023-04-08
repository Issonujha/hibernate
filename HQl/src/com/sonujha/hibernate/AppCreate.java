package com.sonujha.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sonujha.hibernate.entity.Users;

public class AppCreate {

	public static void main(String[] args) {
		
		//Create a session factory first create configuration and then configure it there after add an annotated class and then built the session
		SessionFactory factory = new Configuration()
													.configure("hibernate.cfg.xml")
													.addAnnotatedClass(Users.class)
													.buildSessionFactory();
		//thereafter getting the current session from the factory
		Session session = factory.getCurrentSession();
		
		
		
		//Inside the try block all the database operation takes place
		//Inside the finally block it have to close when all the operation is done on database
		try {
			//Creating an object of entity class
			Users user = new Users("Sonu", "Sonu123@", "Sonu", "Jha");
			
			//start transaction
			session.beginTransaction();
			
			//Perform operation
			session.save(user);
			
			//Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("User Added!");
		}
		catch(HibernateException exception){
		     System.out.println("Problem creating session factory");
		     exception.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
		
		
	}

}
