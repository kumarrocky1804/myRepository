package Searching;

import DataStructures.LinkedList;
import DataStructures.Node;

public class BinarySearchLinkedList
{
	static Node BinarySearch(Node start, int ele)
	{
		Node last = null;
		Node mid = null;
		do
		{
			mid = returnMid(start,last);
			
			System.out.println("CURRENT Start is  - " + start.getData());
			System.out.println("CUrrent Mid is - " + mid.getData());
			if(last != null)
			{
				System.out.println("Current last is  - " + last.getData());
			}
			
			System.out.println();
			
			if(mid.getData() == ele)
			{
				return mid;
			}
			else if(mid.getData() > ele)
			{
				last = mid;
			}
			else // mid.getData() < ele
			{
				start = mid.getNext();
			}
		}while(last == null || last != start);
		
		return null;
	}
	
	//IF LAST IS NULL, THE FUNCTION WILL FIND MID OF FULL LIST
	static public Node returnMid(Node start, Node last)
	{
		Node slow,fast;
		if(start == null)
		{
			return null;
		}
		else
		{
			slow = start;
			fast = start.getNext();
			
			/* move the slow pointer one step and fast pointer 2 steps
			 * and keep comparing the fast to be null.
			 * if at any time, fast is null, return the slow pointer
			 * THIS WILL RETURN THE MID ELEMENT FOR ODD NUMBER OF ELEMENTS AND 
			 * THE LOWER MID FOR EVEN NUMBER OF ELEMENTS
			 */
			while(fast != last)
			{
				fast = fast.getNext();
				if(fast == last)
				{
					return slow;
				}
				else
				{
					slow = slow.getNext();
					fast = fast.getNext();
				}
			}
			return slow;
			
		}
	}
	
	//IF LAST IS NULL, THE FUNCTION WILL FIND MID OF FULL LIST
	static Node returnMid(Node start)
	{
		Node slow,fast;
		if(start == null)
		{
			System.out.println("LIST IS EMPTY");
			return null;
		}
		else
		{
			slow = start;
			fast = start.getNext();
			
			/* move the slow pointer one step and fast pointer 2 steps
			 * and keep comparing the fast to be null.
			 * if at any time, fast is null, return the slow pointer
			 * THIS WILL RETURN THE MID ELEMENT FOR ODD NUMBER OF ELEMENTS AND 
			 * THE UPPER MID FOR EVEN NUMBER OF ELEMENTS
			 */
			while(fast != null)
			{
				fast = fast.getNext();
				if(fast == null)
				{
					return slow.getNext();
				}
				else
				{
					slow = slow.getNext();
					fast = fast.getNext();
				}
			}
			return slow;
			
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addEnd(new Node(1));
		list.addEnd(new Node(2));
		list.addEnd(new Node(3));
		list.addEnd(new Node(4));
		list.addEnd(new Node(5));
		list.addEnd(new Node(6));
		list.addEnd(new Node(7));
		list.addEnd(new Node(8));
		list.addEnd(new Node(9));
		//list.addEnd(new Node(45));
		
		list.displayFromNode(list.getHead());
		System.out.println();
		//System.out.println(BinarySearchLinkedList.returnMid(list.getHead(),null).getData());
		
		System.out.println(BinarySearchLinkedList.returnMid(list.getHead()).getData());
		
		/*Node node;
		node = BinarySearch(list.getHead(),45);
		if(node == null)
		{
			System.out.println("ELEMENT NOT FOUND");
		}
		else
		{
			System.out.println("ELEMENT FOUND");
		}*/
	}
}
