package hbOneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

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

			Instructor instructor = new Instructor("John", "Doe", "john.doe@gmail.com"
					, new InstructorDetail("http://yt/john.doe","Coding"));
			
			Course course = new Course("JAVA");
			Course course2 = new Course("PYTHON");
			
			// this will create the bidirectional links
			instructor.addCourse(course2);
			instructor.addCourse(course);

			// begin transaction
			session.beginTransaction();

			// save
			// it will also save instructor details
			// need to save courses as well
			session.save(course);
			session.save(course2);
			session.save(instructor);
			

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
