package PracticeQuestions;

import DataStructures.Node;
import DataStructures.LinkedList;

public class Merge2SortedLinkedLists 
{
	static public Node mergeSortedList(Node headA, Node headB)
	{
		if(headA==null)
			return headB;
		if(headB==null)
			return headA;
		
		Node dummyHead = new Node(0);
		Node finalListTail = dummyHead;
		
		Node currA = headA;
		Node currB = headB;
		
		while(currA!=null || currB!=null)
		{
			if(currB==null)
			{
				finalListTail.setNext(currA);
				currA = currA.getNext();
			}
			else if(currA==null)
			{
				finalListTail.setNext(currB);
				currB = currB.getNext();
			}
			else if(currA.getData()<=currB.getData())
			{
				finalListTail.setNext(currA);
				currA = currA.getNext();
			}
			else
			{
				finalListTail.setNext(currB);
				currB = currB.getNext();
			}
			finalListTail = finalListTail.getNext();
		}
		
		return dummyHead.getNext();
		
	}
	public static void main(String[] args) 
	{
		LinkedList list1 = new LinkedList();
		list1.addEnd(new Node(2));
		list1.addEnd(new Node(3));
		list1.addEnd(new Node(4));
		list1.addEnd(new Node(10));
		
		LinkedList list2 = new LinkedList();
		list2.addEnd(new Node(1));
		list2.addEnd(new Node(4));
		list2.addEnd(new Node(20));
		
		list1.display();
		System.out.println();
		list2.display();
		System.out.println();
		list1.setHead(mergeSortedList(list1.getHead(), list2.getHead()));
		
		list1.display();
	}

}
