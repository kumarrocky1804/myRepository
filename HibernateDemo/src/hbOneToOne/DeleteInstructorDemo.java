package hbOneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class DeleteInstructorDemo 
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
			Instructor instructor = session.get(Instructor.class, 1);
			
			//delete if not null
			System.out.println("Data returned - " + instructor);
			
			if(instructor != null)
			{
				// it will also delete instructor details as cascading is set to all
				session.delete(instructor);
			}

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