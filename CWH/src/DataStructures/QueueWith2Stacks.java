package DataStructures;

import java.util.Stack;

public class QueueWith2Stacks 
{
	Stack<Integer> mainStack;
	Stack<Integer> tempStack;
	
	public QueueWith2Stacks()
	{
		mainStack = new Stack<Integer>();
		tempStack = new Stack<Integer>();
	}
	
	// insert from rear
	public void EnQueue(int data)
	{
		// top element of main stack is rear
		mainStack.push(data);
	}
	
	// delete from front
	public int DeQueue()
	{
		// if no elements
		if(mainStack.isEmpty())
		{
			return -1;
		}
		
		// put all elements to another stack to reverse its order
		while(!mainStack.isEmpty())
		{
			tempStack.push(mainStack.pop());
		}		
		
		// top element is the front of queue
		int front = tempStack.pop();
		
		// put everything back
		while(!tempStack.isEmpty())
		{
			mainStack.push(tempStack.pop());
		}
		
		return front;
	}
	
	public static void main(String[] args) {
		QueueWith2Stacks q = new QueueWith2Stacks();
		
		q.EnQueue(1);
		q.EnQueue(2);
		q.EnQueue(3);
		
		System.out.println(q.DeQueue());
		System.out.println(q.DeQueue());
		System.out.println(q.DeQueue());
		System.out.println(q.DeQueue());
	}
}
