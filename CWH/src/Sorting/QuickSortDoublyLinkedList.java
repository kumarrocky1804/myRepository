package Sorting;

import DataStructures.DoublyNode;
import DataStructures.DoublyLinkedList;

public class QuickSortDoublyLinkedList 
{
	static DoublyNode partition(DoublyNode head, DoublyNode low, DoublyNode high)
	{
		DoublyNode pivot = high;
		DoublyNode prepivot = null;
		DoublyNode currNode = head;
		
		while(currNode != high)
		{
			if(currNode.data < pivot.data)
			{
				if(prepivot==null)
					prepivot=head;
				else
					prepivot=prepivot.next;
				
				int temp = prepivot.data;
				prepivot.data = currNode.data;
				currNode.data = temp;
			}
			currNode = currNode.next;
		}
		
		if(prepivot==null)
			prepivot=head;
		else
			prepivot=prepivot.next;
		
		int temp = prepivot.data;
		prepivot.data = pivot.data;
		pivot.data = temp;
		
		return prepivot;
	}
	
	static void sort(DoublyNode head, DoublyNode low, DoublyNode high)
	{
		if(high==null||low==high||low==high.next)
			return;
		// after each iteration the pivot will contain the element at correct position
		DoublyNode pivot = partition(head,low,high);
		
		// Rest of the left and right arrays will be then sorted
			sort(head,low,pivot.prev);
			sort(head,pivot.next, high);
	}
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtEnd(4);
		list.addAtEnd(5);
		list.addAtEnd(1);
		list.addAtEnd(10);
		list.addAtEnd(0);
		list.addAtEnd(523);
		list.addAtEnd(1023);
		list.addAtEnd(95);
		list.addAtEnd(90);
		
		list.display();
		System.out.println();
		DoublyNode last = list.head;
		while(last.next != null)
		{
			last = last.next;
		}
		sort(list.head, list.head, last);
		list.display();
	}
}
