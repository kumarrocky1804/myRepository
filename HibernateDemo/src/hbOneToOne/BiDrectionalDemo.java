package hbOneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class BiDrectionalDemo 
{
	public static void main(String[] args) 
	{
		// creating session factory only once in app
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfgOneToOneUni.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		try
		{
			// creating session
			Session session = factory.getCurrentSession();

			// begin transaction
			session.beginTransaction();

			// get the data
			InstructorDetail detail = session.get(InstructorDetail.class, 2);

			// actual commit of transactions
			session.getTransaction().commit();
			
			System.out.println("Details - " + detail);
			System.out.println("Attached Instructor - " /*+ detail.getInstructor()*/);
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
