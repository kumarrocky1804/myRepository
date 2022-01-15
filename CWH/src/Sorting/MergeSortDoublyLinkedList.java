package Sorting;

import DataStructures.DoublyLinkedList;
import DataStructures.DoublyNode;

public class MergeSortDoublyLinkedList 
{
	/* Same logic and control flow as singly linked list
	 *  - Just extra management for prev pointer.
	 */
	// another logic to find the middle of linked list in O(n)
	public static DoublyNode returnMid(DoublyNode head)
	{
		DoublyNode currNode = head;
		DoublyNode midNode = head;
		
		if(currNode==null)
			return null;
		
		int n=0;
		while(currNode.next!=null)
		{
			currNode=currNode.next;
			n++;
			if(n%2==0)
				midNode = midNode.next;
		}
		return midNode;
	}
	
	public static DoublyNode mergeSortedList(DoublyNode headLeft, DoublyNode headRight)
	{
		if(headLeft==null)
			return headRight;
		if(headRight==null)
			return headLeft;
		
		DoublyNode dummyNode = new DoublyNode(0);
		DoublyNode finalListTail = dummyNode;
		
		DoublyNode currLeft = headLeft;
		DoublyNode currRight = headRight;
		
		while(currLeft!=null||currRight!=null)
		{
			if(currLeft==null)
			{
				finalListTail.next=currRight;
				currRight.prev = finalListTail;
				currRight = currRight.next;
			}
			else if(currRight==null)
			{
				finalListTail.next=currLeft;
				currLeft.prev = finalListTail;
				currLeft = currLeft.next;
			}
			else if(currLeft.data<=currRight.data)
			{
				finalListTail.next=currLeft;
				currLeft.prev = finalListTail;
				currLeft = currLeft.next;
			}
			else
			{
				finalListTail.next=currRight;
				currRight.prev = finalListTail;
				currRight = currRight.next;
			}
			finalListTail = finalListTail.next;
		}
		dummyNode.next.prev=null;
		return dummyNode.next;
	}
	
	public static DoublyNode mergeSort(DoublyNode head)
	{
		if(head==null||head.next==null)
			return head;
		
		DoublyNode middle = returnMid(head);
		DoublyNode nextToMiddle = middle.next;
		middle.next = null;
		
		DoublyNode left = mergeSort(head);
		DoublyNode right = mergeSort(nextToMiddle);
		
		DoublyNode sortedListHead = mergeSortedList(left, right);
		return sortedListHead;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtEnd(1);
		list.addAtEnd(8);
		list.addAtEnd(9);
		list.addAtEnd(11);
		list.addAtEnd(12);
		list.addAtEnd(3);
		list.addAtEnd(5);
		list.addAtEnd(12);
		list.addAtEnd(15);
		list.addAtEnd(20);
		
		list.display();
		System.out.println();
		//System.out.println(returnMid(list.head).data);
		
		//DoublyLinkedList list2 = new DoublyLinkedList();
		//list2.addAtEnd(3);
		//list2.addAtEnd(5);
		//list2.addAtEnd(12);
		//list2.addAtEnd(15);
		//list2.addAtEnd(20);
		
		//System.out.println();
		//list2.display();
		//System.out.println();
		//list.head = mergeSortedList(list.head, list2.head);
		//list.display();
		
		System.out.println();
		list.head = mergeSort(list.head);
		list.display();
	}
}
