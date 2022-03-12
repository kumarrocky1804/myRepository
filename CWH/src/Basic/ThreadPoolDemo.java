package Basic;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* This program will demonstrate the thread pool/ executor service working
 * A pool of 3 threads will be created to handle 5 threads of 2 different tasks.
 */

class Task1 implements Runnable
{
	private String name;
	
	Task1(String name)
	{
		this.name = name;
	}
	
	@Override
	public void run()
	{
		try
		{
			for(int i=0; i<5; i++)
			{
				System.out.println("Task 2 for Thread - " + name +
						" Loop value - " + i);
				Thread.sleep(500);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

class Task2 implements Runnable
{	
	private String name;
	
	Task2(String name)
	{
		this.name = name;
	}
	
	@Override
	public void run()
	{
		try
		{
			for(int i=0; i<5; i++)
			{
				System.out.println("Task 1 for Thread - " + name +
						" Loop value - " + i);
				Thread.sleep(500);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

class Task3 implements Runnable
{	
	private String name;
	
	Task3(String name)
	{
		this.name = name;
	}
	
	@Override
	public void run()
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println(" Thread - " + name + " Enter input - ");
			int a = sc.nextInt();
			System.out.println(" Thread - " + name + " The output is - ");
			System.out.println(a);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			sc.close();
		}
	}
}

public class ThreadPoolDemo 
{
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		Runnable thread1 = new Task1("First");	
		Runnable thread2 = new Task2("Second");	
		Runnable thread3 = new Task3("Third");	
		Runnable thread4 = new Task2("Fourth");	
		Runnable thread5 = new Task1("Fifth");	
		
		service.execute(thread1);
		service.execute(thread2);
		service.execute(thread3);
		service.execute(thread4);
		service.execute(thread5);
		// FIrst 3 will be executed and last 2 will be in queue
		// as soon as any of 3 threads is idle, another thread from queue will be executed.
		
		service.shutdown();
	}
}
	