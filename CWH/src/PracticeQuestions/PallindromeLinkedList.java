package PracticeQuestions;

import DataStructures.Node;
import DataStructures.LinkedList;
import java.util.Stack;

public class PallindromeLinkedList {
	/* This approach is to put the list into the stack and then pop it
	 * one by one and compare it to the original elements.
	 * this will compare the linked list with the stack elements that has the
	 * list elements in reverse order.
	 * TIME - O(n), SPACE - extra O(n)
	 */
	static boolean checkPallindrome(Node start)
	{
		Stack<Node> s = new Stack<Node>();
		Node currNode = start;
		while(currNode != null)
		{
			s.push(currNode);
			currNode = currNode.getNext();
		}
		
		currNode = start;
		while(currNode != null)
		{
			if(currNode.getData() != s.pop().getData())
			{
				return false;
			}
			currNode = currNode.getNext();
		}
		
		return true;
	}
	
	/* One more approach can be to find the middle of linked list
	 * then reverse the second half
	 * compare with first half.
	 * 
	 * Challenges - if elements are odd, keep track of middle element
	 * time - O(n) but 3 loops, SPACE - No EXtra
	 */
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addEnd(new Node(1));
		list.addEnd(new Node(2));
		list.addEnd(new Node(2));
		list.addEnd(new Node(1));
		
		list.display();
		System.out.println();
		
		if(checkPallindrome(list.getHead()))
		{
			System.out.println("THE LIST IS PALLINDROME");
		}
		else
		{
			System.out.println("REALLY!!! THAT LOOKS PALLINDROME TO YOU...ARE YOU BLIND??");
		}
	}
}
