package hbManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student2;

public class GetDemo 
{
	public static void main(String[] args)
	{
		// creating session factory only once in app
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfgManyToMany.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Student2.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = null;
		try
		{
			// creating session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Course course = session.get(Course.class, 14);
			
			System.out.println("Course is - " + course);
			
			System.out.println("\n Students for this course are - ");
			
			System.out.println(course.getStudents());
			
			Student2 student = session.get(Student2.class, 1);
			
			System.out.println("Student is - " + student);
			
			System.out.println("\n Courses for this student are - ");
			
			System.out.println(student.getCourses());

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
