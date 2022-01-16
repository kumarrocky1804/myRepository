package PracticeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBinary 
{
	// The problem is to print binary from 1 to N. O(n) complexity
	/* Solution Hint - Binary number depends on previous numbers  - 
	 * 			  1 is 1, 2 is 10, 3 is 11, 4 is 100, 5 is 101 so on,
	 * 			  If we append 0 and 1 to "1" it will become 10 (2) and 11 (3)
	 * 			  If we append 0 and 1 to "2" it will become 100 (4) and 101 (5) and so on.
	 */
	
	/* This is dynamic programming as we are using the results of previous functions to find
	 * the results of new problem.
	 * In most cases, we use arrays in dynamic programming but here we don't exactly know the 
	 * index of new results as the old results, so we are using queue.
	 */
	
	public static void printBinary(int n)
	{
		Queue<String> q = new LinkedList<String>();
		
		// for 1st number
		q.add("1");
		int count = 1;
		
		while(count <=n)
		{
			// the front is the binary of next number
			System.out.println("Binary of " + count + "is - " + q.peek());
			
			// store this string to create next two binary
			String s1 = q.peek();
			String s2 = s1;
			
			// now its fine to remove front 
			q.remove();
			
			// find the binary of next two numbers and add it.
			q.add(s1 + "0");
			q.add(s2 + "1");
			count++;
		}
	}
	
	public static void main(String[] args) {
		int n=10;
		
		printBinary(10);
	}
}
