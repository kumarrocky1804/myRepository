package Sorting;

import DataStructures.Node;
import DataStructures.LinkedList;
import Searching.BinarySearchLinkedList;
import PracticeQuestions.Merge2SortedLinkedLists;

public class MergeSortLinkedList 
{
	public static Node mergeSort(Node head)
	{
		if(head==null || head.getNext()==null)
			return head;
		
		Node middle = BinarySearchLinkedList.returnMid(head, null);
		Node nextToMiddle = middle.getNext();
		
		//to make last node as null for next iteration
		middle.setNext(null);
		
		Node headLeft = mergeSort(head);
		Node headRight = mergeSort(nextToMiddle);
		
		Node sortedListHead = Merge2SortedLinkedLists.mergeSortedList(headLeft, headRight);
		
		return sortedListHead;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.addEnd(new Node(2));
		list1.addEnd(new Node(10));
		list1.addEnd(new Node(100));
		list1.addEnd(new Node(20));
		
		list1.display();
		System.out.println();
		
		list1.setHead(mergeSort(list1.getHead()));
		
		System.out.println();
		list1.display();
	}
}
