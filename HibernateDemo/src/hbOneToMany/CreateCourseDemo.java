package hbOneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class CreateCourseDemo 
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

			Instructor instructor = new Instructor("Anu", "Malik", "anu.malik@gmail.com"
					, new InstructorDetail("http://yt/anu.malik","Music"));
			
			Course course = new Course("voilin");
			//Course course2 = new Course("Tabla");
			
			// this will create the bidirectional links
			course.setInstructor(instructor);
			//course2.setInstructor(instructor);

			// begin transaction
			session.beginTransaction();

			// save
			session.save(instructor);
			session.save(course);
			//session.save(course2);			

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
