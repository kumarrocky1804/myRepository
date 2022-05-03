package hbManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student2;

public class CreateStudentsForCourses 
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
			
			Course course1 = new Course("C++");
			
			Student2 student = new Student2("Rocky", "kumar", "rocky.kumar@gmail.com");
			Student2 student2 = new Student2("Ram", "Dinkar", "ram.dinkar@gmail.com");
			
			course1.addStudent(student);
			course1.addStudent(student2);
			
			//save the course
			session.save(course1);
			
			// save the students
			session.save(student);
			session.save(student2);

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
