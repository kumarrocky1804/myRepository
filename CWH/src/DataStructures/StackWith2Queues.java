package DataStructures;

import java.util.Queue;
import java.util.LinkedList;

public class StackWith2Queues {
	Queue<Integer> mainQueue, tempQueue;
	
	public StackWith2Queues()
	{
		mainQueue = new LinkedList<Integer>();
		tempQueue = new LinkedList<Integer>();
	}
	
	public void push(int data)
	{
		mainQueue.add(data);
	}
	
	public int pop()
	{
		if(mainQueue.isEmpty())
		{
			return -1;
		}
		
		// remove everything but not last element
		while(mainQueue.size() != 1)
		{
			tempQueue.add(mainQueue.remove());
		}
		
		// return last element
		int retElement = mainQueue.remove();
		
		// put everything back in queue
		/*while(!tempQueue.isEmpty())
		{
			mainQueue.add(tempQueue.remove());
		}*/
		
		// another way is to just exchange references
		Queue<Integer> q = mainQueue;
		mainQueue = tempQueue;
		tempQueue = q;
		return retElement;
	}
	
	public static void main(String[] args) {
		StackWith2Queues st = new StackWith2Queues();
		st.push(1);
		st.push(2);
		st.push(3);
		
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}
