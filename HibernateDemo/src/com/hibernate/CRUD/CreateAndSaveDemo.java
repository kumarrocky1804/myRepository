package com.hibernate.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class CreateAndSaveDemo 
{
	public static void main(String[] args) {
		// creating session factory only once in app
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		try
		{
			// creating session
			Session session = factory.getCurrentSession();
			
			Student tempStudent = new Student("John","Doe","john.doe@gmail.com",
								DateUtils.stringToDate("18/04/1997"));
			
			// begin transaction
			session.beginTransaction();
			
			// save
			session.save(tempStudent);
			
			// actual commit of transactions
			session.getTransaction().commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			factory.close();
		}
	}
}
