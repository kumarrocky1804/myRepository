package com.hibernate.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class UpdateDemo {

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
			/*Student student = session.get(Student.class, 9);
			student.setEmail("changedEmail@gmmail.com");*/
			
			//option 2 with HQL query
			session.createQuery("Update Student s set s.email='changedEmail2@gmail.com' "
					+ "where s.email='changedEmail@gmmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			// READ AGAIN
			session = factory.getCurrentSession();
			session.beginTransaction();

			Student student2 = session.get(Student.class, 9);
			
			session.getTransaction().commit();			
			System.out.println(student2);
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
