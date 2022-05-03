package hbOneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class DeleteCourseDemo 
{
	public static void main(String[] args)
	{
		// creating session factory only once in app
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfgOneToOneMany.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = null;
		try
		{
			// creating session
			session = factory.getCurrentSession();

			// begin transaction
			session.beginTransaction();
			
			Course course = session.get(Course.class, 22);
			
			System.out.println("Courses - " +course);
			
			if(course != null)
			{
				session.delete(course);
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
			session.close();
			factory.close();
		}
	}
}
