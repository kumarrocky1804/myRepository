package DesignPatterns.CreationalDesignPatterns;
/* we will create a service that can notify the user via sms, email and push
 * Using Factory Pattern
 * This pattern can be used when loose coupling is needed for new object creation of similar
 * functionalities.
 * 
 * Creational design patterns
 */

//==========================LIBRARY SIDE CLass=========================================
interface Notification
{
	void notifyUser();
}

class SMSNotification implements Notification
{
	@Override
	public void notifyUser()
	{
		System.out.println("User notified via SMS");
	}
}

class EmailNotification implements Notification
{
	@Override
	public void notifyUser()
	{
		System.out.println("User notified via Email");
	}
}

class PushNotification implements Notification
{
	@Override
	public void notifyUser()
	{
		System.out.println("User notified via Push on the app");
	}
}

// Factory class
class NotificationFactory
{
	public Notification createNotification(String type) throws Exception
	{
		switch(type)
		{
		case "SMS": return new SMSNotification();
		case "Email": return new EmailNotification();
		case "Push": return new PushNotification();
		default: throw new Exception("wrong object type passed");
		}
	}
}
//==================================USER SIDE CLASS==========================
// main class
public class FactoryPatternDemo 
{
	public static void main(String[] args) throws Exception {
		NotificationFactory not = new NotificationFactory();
		Notification notification = not.createNotification("SMS");
		notification.notifyUser();
	}
}

/*
 * Disadvantage is that if I want to create new type of notification, I will need to modify NotificationFactory
 * class, which does not follow Open/closed principle from SOLID
 * For better approach- FactoryPatternDemoV2
 * */
