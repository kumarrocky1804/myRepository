package hbOneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo 
{
	public static void main(String[] args) {
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
			
			Instructor instructor = new Instructor("Ravi", "Shastri", "ravi.shastri@gmail.com"
					,new InstructorDetail("channel","hobby"));
			
			// begin transaction
			session.beginTransaction();
			
			// save
			// due to cascading set to all, it will also save instructor details in DB
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
			factory.close();
		}
	}
}
