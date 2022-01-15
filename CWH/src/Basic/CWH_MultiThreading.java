package Basic;

class MyThread2 implements Runnable
{

	@Override
	public void run() {
		System.out.println("Sample Thread made by implementing interface");
		
	}
	
}

class MyThread extends Thread
{
	@Override
	public void run()
	{
		for(int i=0; i<100; i++)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
		}
	}
}

public class CWH_MultiThreading {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.setName("First");
		MyThread t2  = new MyThread();
		t2.setName("Second");
		
		t1.start();
		// WAIT 5000 ms for t1 to complete
		try {
			t1.join(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		
		// THread by Interface
		/*MyThread2 obj = new MyThread2();
		Thread t = new Thread(obj);
		t.start();*/
	}
}

