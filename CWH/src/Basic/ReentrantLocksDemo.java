package Basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* The disadvantage of synchronized is that we can acquire class level or object level locks
 * and cannot have 2 or more locks for different methods. We can do the same with Locks framework
 * since java 1.5
 * 
 * Below is an example where 2 locks are made for two different dummy jobs
 */

class TestResource
{
	/* This class will have 2 methods and 2 locks for the same */
	
	private final Lock Job1Lock = new ReentrantLock();
	private final Lock Job2Lock = new ReentrantLock();
	
	public void job1()
	{
		Job1Lock.lock();
		try
		{
			System.out.println(Thread.currentThread().getName() + " is working on job1 ");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " is done with job1 ");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			Job1Lock.unlock();
		}
	}
	
	public void job2()
	{
		Job2Lock.lock();
		try
		{
			System.out.println(Thread.currentThread().getName() + " is working on job2 ");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " is done with job2 ");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			Job2Lock.unlock();
		}
	}
}

// A class that uses job1 of test resource
class Job1 implements Runnable
{
	TestResource res;
	
	Job1(TestResource res)
	{
		this.res = res;
	}
	
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + " is going for job1 ");
		res.job1();
	}
}

//A class that uses job2 of test resource
class Job2 implements Runnable
{
	TestResource res;
	
	Job2(TestResource res)
	{
		this.res = res;
	}
	
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + " is going for job2 ");
		res.job2();
	}
}

public class ReentrantLocksDemo 
{
	public static void main(String[] args) {
		// A shared resource
		TestResource res = new TestResource();
		
		Thread[] threads = new Thread[6];
		// 6 threads 3 for each job
		for(int i = 0; i<3; i++)
		{
			threads[i] = new Thread(new Job1(res));
			threads[i].setName("Thread - " + i + " ");
		}
		
		for(int i = 3; i<6; i++)
		{
			threads[i] = new Thread(new Job2(res));
			threads[i].setName("Thread - " + i + " ");
		}
		
		for(int i=0; i<6; i++)
		{
			threads[i].start();
		}
		
		for (int i=0; i<6; i++)
		{
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/* different threads can pick job1 and job2 of same resource simultaneously
		 * if the lock for that job is free. 
		 */
	}
}
