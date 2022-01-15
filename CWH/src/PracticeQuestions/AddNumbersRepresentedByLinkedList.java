package PracticeQuestions;

import DataStructures.Node;
import DataStructures.ReverseLinkedList;

public class AddNumbersRepresentedByLinkedList 
{
	public static Node AddLists(ReverseLinkedList listA, ReverseLinkedList listB)
	{
		// reverse the list to get unit digits as head
		listA.reverseList();
		listB.reverseList();
		
		// find list with more values
		Node greatHead = listA.getHead();
		Node smallHead = listB.getHead();
		Node last=null;
		
		if(listB.getLength()>listA.getLength())
		{
			greatHead = listB.getHead();
			smallHead = listA.getHead();
		}
		
		int sum=0,carry=0;
		
		// addition and creation of elements
		while(greatHead!=null)
		{
			if(smallHead==null)
				sum = greatHead.getData() + carry;
			else
			{
				sum = greatHead.getData() + smallHead.getData() + carry;
				smallHead = smallHead.getNext();
			}
			
			carry = sum/10;
			sum = sum%10;
			
			greatHead.setData(sum);
			last = greatHead;
			greatHead = greatHead.getNext();
		}
		
		// if carry is still there return it.
		if(carry != 0)
		{
			last.setNext(new Node(carry));
		}
		
		listA.reverseList();
		listB.reverseList();
		
		if(listB.getLength()>listA.getLength())
		{
			return listB.getHead();
		}
		return listA.getHead();
		
		//System.out.println();
		//listA.display();
		//System.out.println();
		//listB.display();
		
		//return returnHead;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList listA = new ReverseLinkedList();
		ReverseLinkedList listB = new ReverseLinkedList();
		
		listA.addEnd(new Node(9));
		listA.addEnd(new Node(5));
		listA.addEnd(new Node(9));
		
		listB.addEnd(new Node(8));
		listB.addEnd(new Node(4));
		listB.addEnd(new Node(4));
		listB.addEnd(new Node(4));
		
		listA.display();
		System.out.println();
		listB.display();
		System.out.println();
		
		listA.setHead(AddLists(listA, listB));
		
		listA.display();
	}
}
