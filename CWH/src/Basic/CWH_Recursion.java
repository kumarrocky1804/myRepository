package Basic;

public class CWH_Recursion {
	
	static void pattern1(int n)
	{
		if(n > 0)
		{
			for(int i=0; i<n; i++)
			{
				System.out.print("*");
			}
			System.out.println();
			pattern1(n-1);
		}
		
	}
	
	static void pattern2(int n)
	{
		if(n > 0)
		{
			pattern2(n-1);
			for(int i=0; i<n; i++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	// nTH term of fibonacii series
	static int fibonacii(int n)
	{
		if(n<=0)
		{
			System.out.println("Please enter valid value");
			return -1;
		}
		else if(n==1 || n==2)
		{
			return n-1;
		}
		else
		{
			return fibonacii(n-1) + fibonacii(n-2);
		}
	}
	
	
	public static void main(String[] args) {
		// pattern1(5);
		// pattern2(5);
		
		System.out.println(fibonacii(10));
	}
}
