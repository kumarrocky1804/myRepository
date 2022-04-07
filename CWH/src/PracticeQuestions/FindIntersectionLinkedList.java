package PracticeQuestions;

import DataStructures.LinkedList;
import DataStructures.Node;

/** The problem is that there are two linked lists given one is shorter than the other and
 * they both have a common node. Aim is to find that node.
 * 
 * Solution - 1. We can count the number of nodes, find the difference, loop through the 
 * 					longer lists till the difference and then loop them at same time
 * 					till we find that common element.
 * 
 *  2. Same approach but instead of finding the length and the difference, we are going
 *  to restart the loop for a list with other list's head. Once they are both reassigned
 *  to each other's head, they will be at equal distance from common node.
 */

public class FindIntersectionLinkedList {

	public static int intersectionPoint(Node head1, Node head2)
	{
		Node curr1 = head1;
		Node curr2 = head2;
		
		if(curr1 == null || curr2 == null)
			return -1;
		
		while(curr1 != curr2)
		{	
			curr1 = curr1.getNext();
			curr2 = curr2.getNext();
			
			if(curr1==curr2)
			{
				if(curr1==null)
					return -1;
				else
					return curr1.getData();
			}
			
			if(curr1 == null)
				curr1 = head2;
			
			if(curr2 == null)
				curr2 = head1;
		}
		
		if(curr1==null)
			return -1;
		else
			return curr1.getData();
	}
	
	public static void main(String[] args) 
	{
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list2.addEnd(new Node(10));
		list2.addEnd(new Node(15));
		list2.addEnd(new Node(30));
		list2.display();
		System.out.println();
		
		list1.addEnd(new Node(3));
		list1.addEnd(new Node(6));
		list1.addEnd(new Node(9));
		//list1.addEnd(list2.getHead().getNext());
		list1.display();
		
		System.out.println();
		System.out.println(intersectionPoint(list1.getHead(), list2.getHead()));
	}

}
