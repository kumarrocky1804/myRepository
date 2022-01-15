package PracticeQuestions;

import DataStructures.Node;
import DataStructures.LinkedList;

public class RotateLinkedListByK 
{
	/*	Problem is to rotate the linked list counter clockwise by k nodes
	 *  we are going to k th node and ending the list there
	 *  we are tying the end of current list to head.
	 */
	public static Node RotateCounterClockwise(Node head, int k)
	{
		Node currNode = head;
		int count=1;
		
		if (k<=0)
			return head;
		
		//k = k%head.getLength(); IF k> length, here we are assuming it is not
		
		while(count<k)
		{
			currNode = currNode.getNext();
			count++;
		}
		
		Node newStart = currNode.getNext();
		currNode.setNext(null);
		
		currNode = newStart;
		while(currNode.getNext() != null)
		{
			currNode = currNode.getNext();
		}
		currNode.setNext(head);
		return newStart;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addEnd(new Node(10));
		list.addEnd(new Node(20));
		list.addEnd(new Node(30));
		list.addEnd(new Node(40));
		list.addEnd(new Node(50));
		list.addEnd(new Node(60));
		
		list.display();
		
		list.setHead(RotateCounterClockwise(list.getHead(), 2));
		System.out.println();
		list.display();
	}
}
