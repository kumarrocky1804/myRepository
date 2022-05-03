package hbOneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;

public class GetReviewsDemo 
{
	public static void main(String[] args)
	{
		// creating session factory only once in app
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfgOneToManyUni.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = null;
		try
		{
			// creating session
			session = factory.getCurrentSession();
			session.beginTransaction();

			Course course = session.get(Course.class, 10);
			
			System.out.println("course found - " + course);
			
			System.out.println("\n due to lazy fetch - hibernate will query again for reviews \n");
			System.out.println("Reviews are - " + course.getReviews());
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
