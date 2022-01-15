package PracticeQuestions;

import java.util.Stack;

public class NextGreaterElementInRight 
{
	/* Problem is to print next greater element than the current element 
	 * - We are going to use stack
	 */
	
	// Simple solution without stack
	public static long[] nextLargerElement2(long[] arr)
	{
		for(int i=0; i<arr.length;i++)
		{
			long temp = arr[i];
			long currentRightHigh = 0;
			if(i==arr.length-1)
			{
				arr[i] = -1;
				break;
			}
			if(arr[i] < currentRightHigh)
			{
				arr[i] = currentRightHigh;
				continue;
			}
			else
			{
				currentRightHigh = 0;
			}
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[j]>arr[i])
				{
					arr[i] = arr[j];
					break;
				}
			}
			if(arr[i] == temp)
			{
				arr[i] = -1;
			}
		}
		return arr;
	}
	
	// With stack, more efficient
	public static long[] nextLargerElement(long[] arr)
	{
		Stack<Long> stack = new Stack<Long>();
		for(int i=arr.length-1;i>=0;i--)
		{
			long temp = arr[i];
			//if stack is empty, it is last element of array
			if(stack.isEmpty())
				arr[i] = -1;
			// if current element is less than stack's top, stack's top is higher
			else if(arr[i] < stack.peek())
			{
				arr[i] = stack.peek();
			}
			// otherwise look for higher element and store it
			else
			{
				while(stack.peek() < arr[i])
				{
					stack.pop();
					if(stack.isEmpty())
						break;
				}
				if(stack.isEmpty())
					arr[i] = -1;
				else
					arr[i] = stack.peek();
			}
			// push current element as it is lower than highest but can be
			// higher than left side elements of array.
			stack.push(temp);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		long[] arr = {4,5,2,25};
		//long[] arr = {13,7,6,12};
		//long[] arr = {13,12,11,10,9,2,1};
		//arr = nextLargerElement(arr);
		arr = nextLargerElement2(arr);
		System.out.println("New Array is - ");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " , ");
		}
	}
}
