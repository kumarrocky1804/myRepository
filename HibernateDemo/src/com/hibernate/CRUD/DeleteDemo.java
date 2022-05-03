package com.hibernate.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try
		{
			// UPDATE
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			// option 1 with primary key
			/*Student student = session.get(Student.class, 7);
			session.delete(student);*/
			
			//option 2 with HQL query
			session.createQuery("Delete Student s where s.id=9").executeUpdate();
			
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
