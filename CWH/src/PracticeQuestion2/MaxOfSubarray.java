package PracticeQuestion2;

import java.util.ArrayDeque;

/**
 * The problem is to find the max from every subarray of k elements in array of n elements
 * 
 * We can use heap but that will take log n time, to give the max value so, we will use
 * deque that will store the max element in the front and keep inserting the elements from 
 * rear.
 * @author rocky.kumar
 *
 */

public class MaxOfSubarray 
{
	public static void maxOfSubArray(int[] arr, int n, int k)
	{
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		int i=0;
		
		// for first window - 
		for(;i<k;i++)
		{
			// firstly remove if there are any waste elements, i.e. which are less than current
			// element
			while(!queue.isEmpty() && arr[queue.peekLast()] <= arr[i])
				queue.removeLast();
			
			// put the current element
			queue.addFirst(i);
		}
		
		// for next elements
		
		for(;i<n;i++)
		{
			System.out.println(" Current max is - " + arr[queue.peekFirst()]);
			
			// remove elements out of current window
			while(!queue.isEmpty() && queue.peekFirst()<=i-k)
				queue.removeFirst();
			
			// remove elements that are waste
			while(!queue.isEmpty() && arr[queue.peekLast()]<= arr[i])
				queue.removeLast();
			
			// put current element
			queue.addLast(i);
		}
		
		// print last window's element
		System.out.println(arr[queue.peekFirst()]);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,1,4,5,2,3,6};
		
		maxOfSubArray(arr, 9, 3);
	}
}
