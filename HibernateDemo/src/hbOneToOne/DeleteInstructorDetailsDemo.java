package hbOneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class DeleteInstructorDetailsDemo 
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
			InstructorDetail detail = session.get(InstructorDetail.class, 3);
			
			//delete if not null
			System.out.println("Data returned - " + detail);
			
			if(detail != null)
			{
				// it will not delete instructor as cascading is set to all except delete
				// just doing delete thrown an error.
				
				// we have to remove the reference of this detail from instructor table.
				detail.getInstructor().setInstructorDetail(null);
				session.delete(detail);
				
				// above code will run an update on the instructor table to delete the 
				// reference of details table and then delete the record from details table.
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
