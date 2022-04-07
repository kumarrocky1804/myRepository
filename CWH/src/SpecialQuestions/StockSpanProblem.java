package SpecialQuestions;

import java.util.Stack;

/** Given an array of prices of stock on a given day price[i].
 * span[i] should be the number of consecutive days before iTH day when price was lower
 * or equal to price[i].
 * Example - price[i] - {100,80,60,70,60,75,85}
 * 			 span[i]  - {1,1,1,2,1,4,6}
 */

public class StockSpanProblem 
{	
	/** A simple approach is to go to every element of array in two loops and check for prices
	 * complexity - O(n^2)
	 * Another efficient way is to use stacks to store the index of day in stack.
	 * TO reduce the complexity we will keep delete the days on which the price was lower than
	 * current day.
	 * More info on - https://www.geeksforgeeks.org/the-stock-span-problem/
	 */
	
	public static int[] calculateSpan(int[] price)
	{
		int[] span = new int[price.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		// For first element span will always be 1
		stack.push(0);
		span[0] = 1;
		
		for(int i=1; i<price.length; i++)
		{
			// keep deleting days on which prices are lower than current day
			while(!stack.isEmpty() && price[stack.peek()]<=price[i])
				stack.pop();
			
			// if stack is empty, the greatest element is current and hence span
			// should be number of previous days
			if(stack.isEmpty())
				span[i] = i+1;
			// otherwise the span will be the number of days between given day and the
			// day on which price was greater than given day's price
			else
				span[i] = i-stack.peek();
			
			stack.push(i);
		}
		return span;
	}
	
	public static void main(String[] args) {
		int[] price = {100,80,60,70,60,75,85,185};
		int[] span = calculateSpan(price);
		
		for(int i=0; i<span.length; i++)
		{
			System.out.print(span[i] + " -> ");
		}
	}
}
