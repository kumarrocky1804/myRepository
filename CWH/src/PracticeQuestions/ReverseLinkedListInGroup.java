package PracticeQuestions;

import DataStructures.Node;
import DataStructures.LinkedList;

public class ReverseLinkedListInGroup extends LinkedList
{
	/* The problem is to reverse the linked list in group of
	 * k nodes.
	 */
	
	public Node reverse(Node start, int k)
	{
		if(start == null)
			return null;
		
		// keep head in temp store
		Node currNode = start;
		Node next=null;
		Node prev=null;
		
		int count = 0;
		
		// reverse the linking
		while(currNode != null && count<k)
		{
			next = currNode.getNext();
			currNode.setNext(prev);
			prev = currNode;
			currNode = next;
			count++;
		}
		
		/* Now, we have the head as last element as the list is reversed
		 *  so, head.next should point to the previous element of next 
		 *  group of nodes.
		 */
		if(currNode!=null)
			start.setNext(reverse(currNode,k));
		
		// return previous node to attach to head of last list
		return prev;
	}
	
	public static void main(String[] args) 
	{
		ReverseLinkedListInGroup list = new ReverseLinkedListInGroup();
		list.addEnd(new Node(1));
		list.addEnd(new Node(2));
		list.addEnd(new Node(3));
		list.addEnd(new Node(4));
		list.addEnd(new Node(5));
		list.addEnd(new Node(6));
		list.addEnd(new Node(7));
		list.addEnd(new Node(8));
		//list.addEnd(new Node(9));
		
		list.display();
		System.out.println();
		
		list.setHead(list.reverse(list.getHead(), 3));
		list.display();
	}

}
