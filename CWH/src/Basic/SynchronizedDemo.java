package Basic;

class SharedResource
{
	int i;
	// option 2 - make the function synchronized
	public void incrementor()
	{
		// option 3 - make the block synch
		synchronized(this)
		{
			System.out.println(Thread.currentThread().getName() + " working on incrementor");
			try
			{
				Thread.sleep(500);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			for(i=0; i<10; i++)
			{
				System.out.println(Thread.currentThread().getName() + " value of i - " + i);
			}
		}
		
	}
}

class MultiThreader implements Runnable
{
	SharedResource res;
	
	MultiThreader(SharedResource res)
	{
		this.res = res;
	}
	
	@Override
	public void run()
	{
		// option 1 - 
		//synchronized(res)
		//{
			res.incrementor();
		//}
		
	}
}

public class SynchronizedDemo 
{
	public static void main(String[] args) {
		SharedResource res = new SharedResource();
		
		// res is shared between both threads
		Thread thread1 = new Thread(new MultiThreader(res));
		Thread thread2 = new Thread(new MultiThreader(res));
		
		thread1.setName("First Thread");
		thread2.setName("Second Thread");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
