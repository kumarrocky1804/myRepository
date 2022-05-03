package com.hibernate.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class QueryDemo 
{
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try
		{
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			// this is class name with "S" not table name with "s"
			List<Student> students = session.createQuery("from Student s where" +
					" s.firstName='John' and s.email like '%gmail.com'").getResultList();
			
			for(Student student: students)
			{
				System.out.println(student);
			}
			
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
