package PracticeQuestions;

import DataStructures.Node;
import DataStructures.LinkedList;

public class SwapNodesOfLinkedList extends LinkedList{
	
	/* The problem is to swap any two nodes of linked list but the 
	 * condition is that you cannot just swap the contents of nodes
	 * because in real situations, it could be very expensive (list could contains many fields)
	 */
	
	public void swap(int x, int y)
	{
		Node prevX = null, prevY = null, currX = this.getHead(), currY = this.getHead();
		 
		while(currX.getData() != x && currX != null)
		{
			prevX = currX;
			currX = currX.getNext();
		}
		
		while(currY.getData() != y && currY != null)
		{
			prevY = currY;
			currY = currY.getNext();
		}
		
		// if nodes does not exist
		if(currX==null || currY==null || currX == currY)
			return;
		
		// if x is not head
		if(prevX != null)
			prevX.setNext(currY);
		else
			this.setHead(currY);
		
		// if y is not head
		if(prevY != null)
			prevY.setNext(currX);
		else
			this.setHead(currX);
		
		// swap next pointers
		Node temp = currX.getNext();
		currX.setNext(currY.getNext());
		currY.setNext(temp);
		
	}
	

	public static void main(String[] args) 
	{
		SwapNodesOfLinkedList list = new SwapNodesOfLinkedList();
		list.addEnd(new Node(1));
		list.addEnd(new Node(2));
		list.addEnd(new Node(3));
		list.addEnd(new Node(4));
		list.addEnd(new Node(5));
		list.addEnd(new Node(6));
		list.addEnd(new Node(7));
		list.addEnd(new Node(8));
		list.addEnd(new Node(9));
		list.addEnd(new Node(10));
		
		list.display();
		
		list.swap(7, 7);
		list.display();
	}

}
