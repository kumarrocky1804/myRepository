package hbOneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;

public class CreateReviewsDemo 
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

			Course course = new Course("Call of Duty Game Training");
			
			course.addReview(new Review("Great game!!!"));
			course.addReview(new Review("Bad game"));
			course.addReview(new Review("Mediocre"));
			
			// cascading is working here
			session.save(course);

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
