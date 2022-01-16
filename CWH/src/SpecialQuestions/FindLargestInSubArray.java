package SpecialQuestions;

import DataStructures.DequeUsingArray;

public class FindLargestInSubArray 
{
	/* Problem is to find largest element in subarray of k elements.
	 *  Example - {1,2,3,1,4,5,2,3,6} and k=3
	 *          - {3,3,4,5,5,5,6}
	 */
	
	/* 1. Can be easily done in O(n*k) by applying nested loops.
	 * 2. For doing it in O(n) - we will use deque. We will keep removing smaller elements' index
	 *                           from rear.
	 * 							 and front element will only be deleted if the element's index is
	 * 							 out of window of subarray.
	 */
	
	public static int[] FindMaxInSubArray(int[] arr, int k)
	{
		int[] result = new int[arr.length-(k-1)];
		DequeUsingArray deque = new DequeUsingArray(k);
		int i;
		// for first k elements
		for(i=0; i<k; i++)
		{
			// keep removing lesser elements from behind as they are useless
			while(!deque.isEmpty() && arr[i] >= arr[deque.peekRear()])
				deque.removeRear();
			
			// Keep adding new elements from behind
			deque.addRear(i);
		}
		
		// Curently for k elements, front is max and rest are less than it
		int j=0;
		for(i=k;i<arr.length;i++,j++)
		{
			// front is the result for last iteration.
			result[j] = arr[deque.peek()];
			
			// delete which are out of window;
			if(!deque.isEmpty() && deque.peek()==j)
				deque.removeFront();
			
			// again keep deleting lesser elements
			while(!deque.isEmpty()&&arr[i] >= arr[deque.peekRear()])
				deque.removeRear();
			
			deque.addRear(i);
		}
		// for last iteration
		result[j] = arr[deque.peek()];
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,1,4,5,2,3,6};
		//int[] result = FindMaxInSubArray(arr, 3);
		int[] result = FindMaxInSubArray(arr, 9);
		
		for(int i=0; i<result.length; i++)
			System.out.print(result[i] + " -> ");
	}
}
