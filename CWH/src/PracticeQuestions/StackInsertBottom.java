package PracticeQuestions;

import DataStructures.LinkedList;
import DataStructures.Stack;

public class StackInsertBottom 
{
	static public void InsertAtBottom(Stack stack, int data)
	{
		if(stack.isEmpty())
		{
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		InsertAtBottom(stack, data);
		stack.push(temp);
	}
	
	public static void main(String[] args) {
		Stack stack = new LinkedList();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		
		stack.stackDisplay();
		System.out.println();
		InsertAtBottom(stack, 4);
		stack.stackDisplay();
	}
}
