package DataStructures;

import java.util.Stack;

public class StackWithMinimumElement
{
	/* The problem is to create push, pop and retMin functions
	 * retMin - a function that returns the minimum element from stack
	 * At any time, the minimum element should have the minimum element
	 */
	
	int min;
	Stack<Integer> top = new Stack<Integer>();
	
	public void push(int ele)
	{
		if(top.isEmpty())
		{
			top.push(ele);
			min = ele;
		}
		else if(ele >= min)
		{
			top.push(ele);
		}
		else
		{
			top.push(2*ele - min);
			//top.push(ele-min);
			min=ele;
		}
	}
	
	public int pop()
	{
		if(top.isEmpty())
		{
			System.out.println("Stack is empty");
			return -1;
		}
		else if(top.peek() >= min)
		{
			return top.pop();
		}
		else
		{
			int ele = min;
			min = 2*min - top.pop();
			//min = min-top.pop();
			return ele;
		}
	}
	
	public int retMin()
	{
		if(top.isEmpty())
		{
			System.out.println("Stack is Empty");
			return -1;
		}
		return min;
	}
	
	public static void main(String[] args) {
		StackWithMinimumElement s = new StackWithMinimumElement();
		s.push(3);
		s.push(5);
		System.out.println(s.retMin());
		s.push(2);
		s.push(1);
		System.out.println(s.retMin());
		System.out.println(s.pop());
		System.out.println(s.retMin());
		System.out.println(s.pop());
		int x=-1,y=-2;
		System.out.println(x-y);
	}
}
