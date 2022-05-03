package com.hibernate.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class ReadDemo 
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
			
			Student tempStudent = new Student("New","name","new.name@gmail.com",
								DateUtils.stringToDate("05/02/1997"));			
			
			// begin transaction
			session.beginTransaction();
			
			// save
			session.save(tempStudent);
			
			System.out.println(tempStudent);
			// actual commit of transactions
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println(tempStudent);
			
			Student student = session.get(Student.class, tempStudent.getId());
			//Student student = session.get(Student.class, 9);
			
			session.getTransaction().commit();
			
			System.out.println(student);
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
