package DesignPatterns.CreationalDesignPatterns;

//==========================LIBRARY SIDE CLass=========================================
interface Notificatio
{
	void notifyUser();
}

class SMSNotificatio implements Notificatio
{
	public void notifyUser()
	{
		System.out.println("User notified via SMS");
	}
}

class EmailNotificatio implements Notificatio
{
	public void notifyUser()
	{
		System.out.println("User notified via Email");
	}
}

interface NotificatioFactory
{
	Notificatio createNotification();
}

class SMSNotificationFactory implements NotificatioFactory
{
	public Notificatio createNotification()
	{
		return new SMSNotificatio();
	}
}

class EmailNotificationFactory implements NotificatioFactory
{
	public Notificatio createNotification()
	{
		return new EmailNotificatio();
	}
}

//=========================USER SIDE CLASS ===============================
class Client
{
	Notificatio notification;
	
	public Client (NotificatioFactory notificationFactory)
	{
		notification = notificationFactory.createNotification();
	}

	public Notificatio getNotification() {
		return notification;
	}
}

public class FactoryPatternDemoV2 {

	public static void main(String[] args) 
	{
		// similar to how we can connect to DB 
		SMSNotificationFactory smsNotificationFactory = new SMSNotificationFactory();
		Client client = new Client(smsNotificationFactory);
		Notificatio notification = client.getNotification();
		
		notification.notifyUser();
	}

}

/* Can extent client's code without modifying it.
 * Can introduce new subtypes easily.
 * 
 * */
