package PracticeQuestions;

import java.util.Scanner;

public class FibonaciiByDynamicProgramming {
	
	static int fibonacii2(int n)
	{
		/* This is implemented by dynamic programming.
		 * Dynamic programming is like divide and conquer but the difference is 
		 * that we use the previous results to solve bigger problems instead of
		 * merging them at last.
		 * it will take more space by has linear time complexity
		 */
		if(n<=0)
		{
			System.out.println("Invalid value");
			return -1;
		}
		else if(n==1 || n==2)
		{
			return n-1;
		}
		else
		{
			// we will treat arr[0] as 1st term and so on
			int[] arr = new int[n];
			arr[0] = 0;
			arr[1] = 1;
			for(int i=2; i<n; i++)
			{
				arr[i] = arr[i-1] + arr[i-2];
			}
			return arr[n-1];
		}
			
	}
	
	static int fibonacii(int n)
	{
		/* This is implementation by recursion 
		 * It has exponential time complexity
		 */
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
		System.out.println("Enter value of n - ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		//ENTER MORE THAN 40 to feel the difference 
		
		System.out.println("By recursion - ");
		System.out.println(fibonacii(n));
		System.out.println("By Dynamic Programming - ");
		System.out.println(fibonacii2(n));
	}

}
