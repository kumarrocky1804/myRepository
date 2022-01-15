package Sorting;

import DataStructures.LinkedList;
import DataStructures.Stack;

public class SortStackByRecursion 
{
	// Function to insert an element in an stack in sorted manner.
	public static void sortedInsert(Stack stack, int data)
	{
		// if data is less, then push it
		if(stack.isEmpty() || data<=stack.peek())
		{
			stack.push(data);
			return;
		}
		// otherwise find a place for it and then push
		int temp = stack.pop();
		sortedInsert(stack,data);
		stack.push(temp);
	}
	
	// we are using this function to save space
	// it will hold all elements in functional stack call and send the last element to insert 
	// in stack in sorted manner.
	public static void sortStack(Stack stack)
	{
		if(stack.isEmpty())
			return;
		int temp = stack.pop();
		sortStack(stack);
		sortedInsert(stack,temp);
	}
	
	public static void main(String[] args) {
		Stack stack = new LinkedList();
		/*sortedInsert(stack, 100);
		sortedInsert(stack, 50);
		sortedInsert(stack, 200);
		sortedInsert(stack, 23);
		sortedInsert(stack, 22);
		
		stack.stackDisplay();*/
		
		stack.push(1);
		stack.push(2);
		stack.push(142);
		stack.push(12);
		stack.push(132);
		stack.push(33);
		stack.push(564);
		
		sortStack(stack);
		stack.stackDisplay();
		
	}
}
